import glob
import subprocess
import os

def get_jar_files(directory_list):
    jar_files = []
    
    for directory in directory_list.split(':'):
        expanded_files = glob.glob(directory)
        jar_files.extend([file for file in expanded_files if file.endswith('.jar')])
    
    return jar_files

directory_list = '/home/ahmad/hadoop-3.3.6/etc/hadoop:/home/ahmad/hadoop-3.3.6/share/hadoop/common/lib/*:/home/ahmad/hadoop-3.3.6/share/hadoop/common/*:/home/ahmad/hadoop-3.3.6/share/hadoop/hdfs:/home/ahmad/hadoop-3.3.6/share/hadoop/hdfs/lib/*:/home/ahmad/hadoop-3.3.6/share/hadoop/hdfs/*:/home/ahmad/hadoop-3.3.6/share/hadoop/mapreduce/*:/home/ahmad/hadoop-3.3.6/share/hadoop/yarn:/home/ahmad/hadoop-3.3.6/share/hadoop/yarn/lib/*:/home/ahmad/hadoop-3.3.6/share/hadoop/yarn/*'

jar_files = get_jar_files(directory_list)
print(len(jar_files))


for jarfile in jar_files:
    print(jarfile)
    # hadoopdir = "/".join(jarfile.split("/")[3:-1])
    # print(hadoopdir)
    # try: 
    #     os.makedirs(os.path.dirname(hadoopdir))
    # except:
    #     pass
    # command = f"/usr/lib/jvm/java-16-openjdk-amd64/bin/java -jar Phosphor/target/Phosphor-0.1.0-SNAPSHOT.jar {jarfile} {hadoopdir}"
    # subprocess.run(command.split(" "))
