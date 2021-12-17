# just inst fund
inst mod:
    mvn install -DskipTests -f {{mod}}/pom.xml
tree:
    mvn dependency:tree

es-cli:
	elasticsearch-sql-cli

run program +FLAGS='':
    mvn compile exec:java -Dexec.mainClass="com.bluecc.{{program}}" -Dexec.args="{{FLAGS}}"

gen program +FLAGS='':
    mvn compile exec:java -Dexec.mainClass="com.bluecc.gentool.{{program}}" -Dexec.args="{{FLAGS}}" -f gentool/pom.xml

rpc program +FLAGS='':
	mvn compile exec:java -Dexec.mainClass="com.bluecc.facade.{{program}}" -Dexec.args="{{FLAGS}}" -f facade/pom.xml

i program +FLAGS='':
	mvn compile exec:java -Dexec.mainClass="com.bluecc.income.{{program}}" -Dexec.args="{{FLAGS}}" -f income/pom.xml

cli +FLAGS='':
	mvn compile exec:java -Dexec.mainClass="com.bluecc.income.cli.CliMain" -Dexec.args="{{FLAGS}}" -f income/pom.xml

s program +FLAGS='':
	mvn exec:java -Dexec.mainClass="com.bluecc.hubs.{{program}}" -Dexec.args="{{FLAGS}}" -f stub/pom.xml

bang:
    just gen CrudGenTool Person Party PartyRole PartyGroup \
        OrderHeader OrderItem OrderRole OrderItemPriceInfo \
        ProductPrice \
        Invoice InvoiceItem

model name:
	just gen MetaTool {{name}}

# 重新生成sql文件以及hubs.json,
# 根据DataSetUtil.collectEntitiesFromResources中定义的数据文件
regen:
	just gen SqlGenTool

# 重新建表(myql)和生成模型类(querydsl)
recreate:
    mysql -uroot -proot hubs < asset/mysql/hubs.sql
    mvn compile -f domain/pom.xml

# 重新生成types.json文件
types:
	just gen EntityTypesTool

# 根据hubs.json和types.json来生成proto定义
proto:
	just inst fund
	just gen ProtoTool -w

sql:
	# just gen SqlGenTool -s
	mysql -uroot -proot hubs < asset/mysql/hubs.sql
	mysql -uroot -proot testhubs < asset/mysql/hubs.sql

# 生成proto文件对应的java类
stub:
	mvn compile -f stub/pom.xml

build:
	just inst fund
	just inst stub
	mvn compile -f income/pom.xml

income:
	mvn compile -f income/pom.xml

saga:
	mvn compile -f saga/pom.xml

template tpl ent:
	just gen TemplateGen -t {{tpl}} -e {{ent}}

package:
	mvn package -DskipTests

heads:
	just gen GenHeadEntities

console:
	just i cli.ConsoleMain

seed:
	time just i procs.SeedFiles

srv:
	just i endpoint.RpcEndpoints

build-srv:
	just build
	just srv

addon file:
	just gen StereotypeAddons -f {{file}}

livecases:
	just gen StereotypeAddons -t stub/src/main/java/com/bluecc/hubs/livecases dataset/livecases

mesh-proto:
	protoc --plugin=protoc-gen-grpc-java=stub/target/protoc-plugins/protoc-gen-grpc-java-1.40.1-osx-x86_64.exe \
		--grpc-java_out=mesh/src/main/java/ \
		--proto_path=mesh/src/main/proto/ \
		-Istub/src/main/proto transitions.proto

# just profile proto
profile p:
	just gen GenProfile {{p}}

dist:
	mvn package -DskipTests -f income/pom.xml

start:
	java -jar income/target/income-1.0-SNAPSHOT-shaded.jar
