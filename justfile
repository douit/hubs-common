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
	just gen SqlGenTool -s
	mysql -uroot -proot hubs < asset/mysql/hubs.sql

testhubs:
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
