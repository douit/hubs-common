# just inst base
inst mod:
    mvn install -DskipTests -f {{mod}}/pom.xml
tree:
    mvn dependency:tree

run program +FLAGS='':
    mvn compile exec:java -Dexec.mainClass="com.bluecc.{{program}}" -Dexec.args="{{FLAGS}}"

gen program +FLAGS='':
    mvn compile exec:java -Dexec.mainClass="com.bluecc.gentool.{{program}}" -Dexec.args="{{FLAGS}}" -f gentool/pom.xml

rpc program +FLAGS='':
	mvn compile exec:java -Dexec.mainClass="com.bluecc.facade.{{program}}" -Dexec.args="{{FLAGS}}" -f facade/pom.xml

bang:
    just gen CrudGenTool Person Party OrderHeader OrderItem OrderRole OrderItemPriceInfo PartyRole PartyGroup ProductPrice

model name:
	just gen MetaTool {{name}}

# 重新生成sql文件
regen:
	just gen SqlGenTool

# 重新建表和生成模型类
recreate:
    mysql -uroot -proot hubs < asset/mysql/hubs.sql
    cd domain && mvn compile

