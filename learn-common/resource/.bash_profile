#JDK1.8配置
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_101.jdk/Contents/Home  
export CLASSPAHT=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar  
export PATH=$PATH:$JAVA_HOME/bin
#nexus私服配置
export NEXUS_HOME=/Users/bill/Downloads/nexus-2.14.9-01-bundle/nexus-2.14.9-01
export PATH=$PATH:$NEXUS_HOME/bin
#Maven配置
#maven where it is!
export MAVEN_HOME=/Users/bill/java/apache-maven-3.5.3
export PATH=$PATH:$MAVEN_HOME/bin
#Mysql5.7
export MYSQL_HOME=/usr/local/mysql
export PATH=$PATH:$MYSQL_HOME/bin
#go配置
GO_ROOT=/usr/local/Cellar/go/1.10.2/libexec
export GO_ROOT
export GO_PATH=/Users/bill/go
export GO_BIN=$GO_PATH/bin
export PATH=$PATH:$GO_BIN:GO_ROOT/bin
