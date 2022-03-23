 /*
 * Copyright 2022 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


/**
* 
* @author caizi
*
*/
@ShellComponent
public class ShellCommand {
	
	@Autowired
	private SimpleShellCommand simpleShellCommand;

	//--------------------------------------------------------------- 查看 ------------------------------------------------------------------------
    @ShellMethod(value = "查看目录及文件的状态信息等,ll为ls的别名,alias ll='ls -alF'",group = "查看")
    public String ll() {    	 
    	return PrintLog2("1. 查看根目录下的文件及目录.")+
    	PrintLog4("ll /")+
    	PrintLog6()+    	
    	PrintLog2("2. 查看/home目录下的文件及目录.")+
    	PrintLog4("ll /home")+
    	PrintLog6()+
    	PrintLog2("3. 查看当前目录下的文件及目录.")+
    	PrintLog4("ll ./")+
    	PrintLog6()+
    	PrintLog2("4. 查看时输出文件大小的格式如(1K 2M 3G等).")+
    	PrintLog4("ll -h")+
    	PrintLog6()+
    	PrintLog2("5. 查看时按时间排序(倒序).")+
    	PrintLog4("ll -t")+
    	PrintLog6()+
    	PrintLog2("6. 查看时按文件字节大小排序(倒序).")+
    	PrintLog4("ll -S")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "查看文件内容",group = "查看")
    public String cat() {
		return PrintLog2("1. 查看指定文件的内容.")+
		PrintLog4("cat ./12.txt")+
    	PrintLog6()+
		PrintLog2("2. 查看指定文件的内容,并显示行号")+
		PrintLog4("cat -n ./12.txt")+
    	PrintLog6()+
		PrintLog2("3. 查看指定文件的内容,每行结束处显示'$'")+
		PrintLog4("cat -E ./12.txt")+
    	PrintLog6()+
		PrintLog2("4. 以分屏方式查看指定文件的内容.")+
		PrintLog5("   Enter回车键: 向下1行,空格键: 向下滚动一屏.")+		
		PrintLog4("cat ./12.txt|more")+		
    	PrintLog6()+
    	
    	PrintLog2("5. 查看CPU信息.")+
    	PrintLog4("cat /proc/cpuinfo")+
    	PrintLog6();
	}
    
    @ShellMethod(value = "分屏查看文件内容",group = "查看")
    public String less() {
		return PrintLog2("1. 查看指定文件的内容.")+
		PrintLog2("   Enter回车键: 向下1行,空格键: 向下滚动一屏.")+
		PrintLog2("   [PageUp]: 向上滚动一屏,[PageDown]:向下滚动一屏.")+
		PrintLog2("   q键退出.")+
		PrintLog4("less ./12.txt")+
    	PrintLog6();
    }
    
    @ShellMethod(value = "显示当前进程信息",group = "查看")
    public String ps() {
		return PrintLog2("1. 显示当前进程信息.")+
		PrintLog4("ps -ef")+
    	PrintLog6()+
		PrintLog2("2. 显示指定进程信息,如查看java进程.")+
		PrintLog4("ps -ef|grep java")+
    	PrintLog6()+
		PrintLog2("3. 显示当前所有进程信息,并包括其他用户的进程.")+
		PrintLog4("ps -aux")+
    	PrintLog6();
	}
    
    @ShellMethod(value = "查看当前日期",group = "查看")
    public String date() {
		return PrintLog2("1. 查看当前日期")+
		PrintLog4("date")+
    	PrintLog6();
	}
    @ShellMethod(value = "从$PATH设置的环境变量里的目录中查找相关的文件",group = "查看")
    public String which() {
    	return PrintLog2("1. 查找java文件")+
    	PrintLog4("which java")+
    	PrintLog5("/usr/bin/java")+
    	PrintLog6();
    }
    
    @ShellMethod(value = "查看变量内容",group = "查看")
    public String echo() {
    	return PrintLog2("1. 查看$PATH环境变量")+
    	PrintLog4("echo $PATH")+
    	PrintLog5("/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/snap/bin")+
    	PrintLog6()+
    	PrintLog2("2. 查看$JAVA_HOME环境变量")+
    	PrintLog4("echo $JAVA_HOME")+
    	PrintLog5("/opt/jdk-17.0.1")+
    	PrintLog6();

	}
    
    @ShellMethod(value = "显示系统中有哪些登录的用户",group = "查看")
    public String who() {
		return PrintLog2("1. 显示系统中有哪些登录的用户.")+
		PrintLog4("who -l -H -u")+
		PrintLog6();
	}

   
    //-------------------------------------------------------- 用户/群组 --------------------------------------------------------------------------
    @ShellMethod(value = "显示用户的ID及所属群组的ID",group = "用户/群组")
    public String id() {
		return PrintLog2("1, 显示root的ID及所属群组的ID")+
		PrintLog4("id root")+
    	PrintLog6();
	}
    
    //-------------------------------------------------------- 系统信息 --------------------------------------------------------------------------
    @ShellMethod(value = "查看文件或目录占用磁盘空间的大小",group = "系统信息")
    public String du() {
    	return PrintLog2("1. 查看当前目录下所有的文件和目录使用磁盘空间的总大小.")+
    	PrintLog4("du -hs")+
    	PrintLog6()+
    	PrintLog2("2. 查看当前目录下所有的文件和目录各自使用磁盘空间的大小.")+
    	PrintLog4("du -hs *")+
    	PrintLog6();
	}
        
    @ShellMethod(value = "显示磁盘的使用信息",group = "系统信息")
    public String df() {
		return PrintLog2("1. 显示磁盘的使用信息.")+
		PrintLog4("df -h")+
		PrintLog5("文件系统        容量  已用  可用 已用% 挂载点")+
		PrintLog5("tmpfs           6.3G  2.3M  6.3G    1% /run")+
		PrintLog5("/dev/nvme0n1p5  1.3T   16G  1.2T    2% /")+
		PrintLog5("tmpfs            32G   40M   32G    1% /dev/shm")+
    	PrintLog6();
	}
    
    @ShellMethod(value = "查看CPU信息(cpuinfo为文件,不是命令!!!)",group = "系统信息")
    public String cpuinfo() {
    	return PrintLog2("1. 查看CPU信息.")+
    	PrintLog4("cat /proc/cpuinfo")+
    	PrintLog6()+

    	PrintLog2("2. 查看CPU型号.")+
    	PrintLog4("cat /proc/cpuinfo|grep \"model name\"")+
    	PrintLog6();

    }

    @ShellMethod(value = "查看内存信息",group = "系统信息")
    public String free() {
    	return PrintLog2("1. 查看内存信息(以mebibytes为单位-M).")+
    	PrintLog4("free -m")+
    	PrintLog6();

    }

    
    //---------------------------------------------------------------- 文件 --------------------------------------------------------------------------
    @ShellMethod(value = "创建文件或目录的链接",group = "操作文件")
    public String ln() {
    	return PrintStarLog2("1.在当前目录下创建目录的链接,目标目录:/opt/ac    链接名:ac")+
    	PrintStarLog4("ln -s /opt/ac ac")+
    	PrintLog6()+
    	PrintStarLog2("2. 在当前目录下创建文件的链接,目标文件:/opt/a.txt    链接名:12.txt")+
    	PrintStarLog4("ln -s /opt/a.txt 12.txt")+
    	PrintLog6();
    }
    
    @ShellMethod(value = "复制文件或目录",group = "操作文件")
    public String cp() {
    	return PrintStarLog2("1. 将1.txt文件复制到ma目录下.")+
    	PrintStarLog4("cp 1.txt ../ma")+
    	PrintLog6()+
    	PrintStarLog2("2. 将ac目录及其子目录和文件复制到ma目录下,在覆盖已存在的文件时没有提示确认!!!")+
    	PrintStarLog4("cp -r ./ac ./ma")+
    	PrintLog6()+
    	PrintStarLog2("3. 将ac目录及其子目录和文件复制到ma目录下,在覆盖已存在的文件时要求用户确认.")+
    	PrintStarLog4("cp -ri ./ac ./ma")+
    	PrintLog6();
    	    	
	}

    @ShellMethod(value = "删除文件(文件删除后不能恢复请谨慎使用!!!)",group = "操作文件")    
    public String rm() {
    	return PrintStarLog2("1. 删除1.txt文件!!!")+
    	PrintStarLog4("rm ./1.txt")+
    	PrintLog6()+
    	PrintStarLog2("2. 删除1.txt文件并提示确认!!!")+
    	PrintStarLog4("rm -i ./1.txt")+
    	PrintLog6()+
    	PrintStarLog2("3. 删除ac目录并删除其下的所有子目录和文件,并提示确认!!!")+
    	PrintStarLog4("rm -ri ./ac")+
    	PrintLog6();
    	    	
    }
    
    @ShellMethod(value = "重定向生成一个新文件",group = "操作文件",key = {">"})
    public String echoa() {
		return PrintLog2("1. 将输出的屏幕信息重定向生成一个新文件.")+
		PrintLog4("echo \"123\" > ./1.txt")+
		PrintLog4("cat ./1.txt > ./2.txt")+
		PrintLog4("ps -ef > ./3.txt")+
    	PrintLog6();
	}
    
    @ShellMethod(value = "文件目录移动改名",group = "操作文件")
    public String mv() {
    	return PrintStarLog2("1. 将ac目录名改为ab.")+
    	PrintStarLog4("mv ./ac ./ab")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 将1.txt文件名改为2.txt.")+
    	PrintStarLog4("mv ./1.txt ./2.txt")+
    	PrintLog6()+
    	
    	PrintStarLog2("3. 将ac目录移到/opt目录下面.")+
    	PrintStarLog4("mv ./ac /opt/ac")+
    	PrintLog5("  或者")+
    	PrintStarLog4("mv ./ac /opt")+
    	PrintLog6()+
    	
    	PrintStarLog2("4. 将1.txt文件移到/opt目录下面.")+
    	PrintStarLog4("mv ./1.txt /opt")+
    	PrintLog6();
    	
    	
    }

    //-------------------------------------------------------- 压缩 --------------------------------------------------------------------------
    @ShellMethod(value = "压缩/解压文件或目录",group="压缩")
    public String tar() {
    	return PrintStarLog2("1. 压缩ac目录,扩展名以tar.gz结尾.")+
    	PrintStarLog4("tar zcvf ./ac.tar.gz ./ac")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 对指定文件进行解压缩.")+
    	PrintStarLog4("tar zxvf ./ac.tar.gz")+
    	PrintLog6()+
    	
    	PrintStarLog2("3. 压缩ac目录,扩展名以tar.bz2结尾.")+
    	PrintStarLog4("tar jcvf ./ac.tar.bz2 ./ac")+
    	PrintLog6()+
    	
    	PrintStarLog2("4. 对指定文件进行解压缩.")+
    	PrintStarLog4("tar jxvf ./ac.tar.bz2")+
    	PrintLog6();
	}
    
    @ShellMethod(value = "压缩/解压文件",group="压缩")
    public String gzip() {
    	return PrintStarLog2("1. 压缩文件，扩展名以.gz结尾.")+
    	PrintStarLog4("gzip -9 ./1.txt")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 解压文件.")+
    	PrintStarLog4("gzip -d ./1.txt.gz")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "压缩/解压文件或目录",group="压缩")
    public String zip() {
    	return PrintStarLog2("1. 压缩目录，扩展名以.zip结尾.")+
    	PrintStarLog4("zip -r ./ac.zip ./ac")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 解压文件.")+
    	PrintStarLog4("unzip ./ac.zip")+
    	PrintLog6()+
    	
    	PrintStarLog2("3. 显示压缩文件里的内容.")+
    	PrintStarLog4("unzip -v ./ac.zip")+
    	PrintLog6();
    	
    }
    
    
    //-------------------------------------------------------- 目录 --------------------------------------------------------------------------
    @ShellMethod(value = "创建目录",group = "目录")
    public String mkdir() {
    	return PrintStarLog2("1. 在当前目录下创建目录.")+
    	PrintStarLog4("mkdir ./ab")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 级联创建目录(如果ab和ac目录不存在则创建，如存在则忽略).")+
    	PrintStarLog4("mkdir -p ./ab/ac/d")+
    	PrintLog6();
    	
	}
    
    @ShellMethod(value = "删除目录",group = "目录")
    public String rmdir() {
    	return PrintStarLog2("1. 删除当前目录下的ab目录(ab目录里必须为空).")+
    	PrintStarLog4("rmdir ./ab")+
    	PrintLog6();
    	
	}
    
    @ShellMethod(value = "进入指定的目录",group = "目录")
    public String cd() {
    	return PrintStarLog2("1. 进入某个目录.")+
    	PrintStarLog4("cd /home")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 进入当前目录.")+
    	PrintStarLog4("cd .")+
    	PrintLog6()+
    	
    	PrintStarLog2("3. 从当前目录返回上一级目录.")+
    	PrintStarLog4("cd ..")+
    	PrintLog6();
    	
	}
    
    @ShellMethod(value = "显示当前的绝对路径",group = "目录")
    public String pwd() {
		return PrintLog2("1. 显示当前的绝对路径.")+
		PrintLog4("pwd")+
    	PrintLog6();
    	
	}
    
    @ShellMethod(value = "改变目录或文件的读写执行权限",group = "权限")
    public String chmod() {
		return PrintStarLog2("1. 将ac目录权限变为:文件所有者读写执、用户组读执行、其它用户读.")+
		PrintStarLog4("chmod 754 ./ac")+
		PrintLog5("drwxr-xr--  2 www root 4096 12月 27 11:17 ac/")+
    	PrintLog6()+
    	
		PrintStarLog2("2. 将ac目录权限变为:文件所有者读写、用户组读、其它用户读.")+
		PrintStarLog4("chmod 644 ./ac")+
		PrintLog5("drw-r--r--  2 www root 4096 12月 27 11:17 ac/")+
    	PrintLog6()+
    	
		PrintStarLog2("3. 将ac目录权限变为:文件所有者读写执行、用户组无权限、其它用户无权限.")+
		PrintStarLog4("chmod 700 ./ac")+
		PrintLog5("drwx------  2 www root 4096 12月 27 11:17 ac/")+
    	PrintLog6()+
    	
		PrintStarLog2("4. 将ac目录及其所有的子目录和文件的权限变为:文件所有者读写执行、用户组无权限、其它用户无权限.")+
		PrintStarLog4("chmod -R 700 ./ac")+
		PrintLog5("drwx------  2 www root 4096 12月 27 11:17 ac/")+    	
		PrintLog2("5. 权限参数: 0无权限、4读权限(r)、5读执行权限(r x)、6读写权限(rw)、7读写执行权限(rwx)")+
		PrintLog6();
	}
    
    @ShellMethod(value = "改变目录或文件所有者及用户组",group = "权限")
    public String chown() {
    	return PrintStarLog2("1. 改变ac目录的所有者为www、用户组为root")+
    	PrintStarLog4("chown www:root ./ac")+
    	PrintLog5("drwx------  2 www root 4096 12月 27 11:17 ac/")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 改变ac目录及其所有的子目录和文件的所有者为www、用户组为root")+
    	PrintStarLog4("chown -R www:root ./ac")+
    	PrintLog5("drwx------  2 www root 4096 12月 27 11:17 ac/")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "改变目录或文件的用户组",group = "权限")
    public String chgrp() {
    	return PrintStarLog2("1. 改变ac目录的用户组为www")+
    	PrintStarLog4("chgrp www ./ac")+
    	PrintLog5("drwx------  2 root www 4096 12月 27 11:17 ac/")+
    	PrintLog6()+
    	
    	PrintStarLog2("2. 改变ac目录及其所有的子目录和文件的用户组为www")+
    	PrintStarLog4("chgrp -R www ./ac")+
    	PrintLog5("drwx------  2 root www 4096 12月 27 11:17 ac/")+
    	PrintLog6();
    	
    }
    
    //-------------------------------------------------------- 网络 --------------------------------------------------------------------------
    @ShellMethod(value = "检测主机是否能通",group = "网络")
    public String ping() {
    	return PrintLog2("1. 检测主机是否能通(请把abc.abc.com改成您想测试的域名).")+
    	PrintLog4("ping abc.abc.com")+
    	PrintLog5("手动Ctrl+c停止检测")+   	
    	PrintLog4("ping -c 3 abc.abc.com")+
    	PrintLog6()+
    	
    	PrintLog2("2. 从指定的网络接口检测(参数 -I <interface>),\"wlp5s0\"为服务器网卡名字.")+
    	PrintLog4("ping -c 3 -I wlp5s0 abc.abc.com")+
    	PrintLog6()+
    	
    	PrintLog2("3. 以1024bytes大小的数据包发起检测，主要测试网络性能.")+
    	PrintLog4("ping -c 3 -s 1024 abc.abc.com")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "显示网络状态和端口信息",group = "网络")
    public String netstat() {
    	return PrintLog2("1. 显示网络状态和端口信息.")+
    	PrintLog4("netstat")+
    	PrintLog6()+

    	PrintLog2("2. 显示tcp协议端口监听信息.")+
    	PrintLog4("netstat -ant")+
    	PrintLog5("Proto Recv-Q Send-Q Local Address           Foreign Address         State")+
    	PrintLog5("tcp        0      0 127.0.0.53:53(#注:第四列,$4)           0.0.0.0:*               LISTEN")+
    	PrintLog5("tcp        0      0 127.0.0.1:631            0.0.0.0:*               LISTEN")+
    	PrintLog5("tcp        0      0 192.168.0.100:42582     192.168.1.100:443      ESTABLISHED")+
    	PrintLog5(".......................................................................................................................")+
    	PrintLog6()+
    	
    	PrintLog2("3. 显示tcp协议端口监听信息后,并对输出的IP进行汇总排序(倒序).")+
    	PrintLog2("    注：$4第四列,-F':'以冒号为分隔符,$1第一列,uniq -c重复出现的次数,sort -nr按数字(n)倒序(r)排列.")+    	    	
    	PrintLog4("netstat -ant|awk '{ print $4 }'|awk -F':' '{ print $1 }'|uniq -c|sort -nr")+
    	PrintLog5("16 192.168.0.100")+
    	PrintLog5("1 Local")+
    	PrintLog5("1 127.0.0.53")+
    	PrintLog5("1 127.0.0.1")+
    	PrintLog6()+
    	
    	PrintLog2("4. 显示udp协议端口监听信息.")+
    	PrintLog4("netstat -anu")+
    	PrintLog5("Proto Recv-Q Send-Q Local Address           Foreign Address         State")+
    	PrintLog5("udp        0      0 127.0.0.53:53           0.0.0.0:*")+
    	PrintLog5("udp        0      0 192.168.0.100:68        192.168.0.1:67          ESTABLISHED")+
    	PrintLog5("udp        0      0 0.0.0.0:631             0.0.0.0:*")+
    	PrintLog6()+

    	PrintLog2("5. 显示网络状态和端口信息还有sockets的PID等.")+
    	PrintLog4("netstat -anp|more")+
    	PrintLog6()+
    	
    	PrintLog2("6. 显示java程序相关的网络状态和端口信息、PID等.")+
    	PrintLog4("netstat -anp|grep java")+
    	PrintLog5("Proto RefCnt Flags       Type       State         I-Node   PID/Program name     路径")+
    	PrintLog5("unix  2      [ ACC ]     流        LISTENING     52417    3206/java(#注:java的PID)            /tmp/.java_pid3206.tmp")+
    	PrintLog6()+
    	
    	PrintLog2("7. 显示路由表.")+
    	PrintLog4("netstat -r")+
    	PrintLog5("    	Destination     Gateway         Genmask         Flags   MSS Window  irtt Iface")+
    	PrintLog5("    	default         bogon           0.0.0.0         UG        0 0          0 wlp5s0")+
    	PrintLog5("    	link-local      0.0.0.0         255.255.0.0     U         0 0          0 wlp5s0")+
    	PrintLog5("    	192.168.0.0     0.0.0.0         255.255.255.0   U         0 0          0 wlp5s0")+
    	PrintLog6()+

    	PrintLog2("7. 显示网卡信息.")+
    	PrintLog4("netstat -i")+
    	PrintLog5("    	Iface      MTU    RX-OK RX-ERR RX-DRP RX-OVR    TX-OK TX-ERR TX-DRP TX-OVR Flg")+
    	PrintLog5("    	enp4s0    1500        0      0      0 0             0      0      0      0 BMU")+
    	PrintLog5("    	lo       65536     1668      0      0 0          1668      0      0      0 LRU")+
    	PrintLog5("    	wlp5s0    1500    32960      0      0 0         19299      0      0      0 BMRU")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "监听端口传输文件等",group = "网络")
    public String nc() {
		return PrintLog2("1. 传输文件,将源服务器的目录aa(及其子目录和文件)传输到目的服务器中.")+
		PrintLog5("登录目的服务器(192.168.0.100),打开1234端口准备接收文件.")+
		PrintLog4("nc -l 1234|tar zxvf -")+
		PrintLog5("登录源服务器.")+
		PrintLog4("tar zcvf - ./aa|nc 192.168.0.100 1234")+
		PrintLog6();

    }

    @ShellMethod(value = "显示网卡信息等",group = "网络")
    public String ifconfig() {
    	return PrintLog2("1. 显示网卡信息.")+
    	PrintLog4("ifconfig")+
    	PrintLog6();
    	
    }
    
    @ShellMethod(value = "显示路由信息",group = "网络")
    public String route() {
    	return PrintLog2("1. 显示路由信息.")+
    	PrintLog4("route -n")+
    	PrintLog6();
    }
    
    @ShellMethod(value = " 跟踪路由",group = "网络")
    public String traceroute() {
    	return PrintLog2("1. 跟踪路由.")+
    	PrintLog4("traceroute abc.abc.com")+
    	PrintLog6();
    	
	}

    //-------------------------------------------------------- 安装 ----------------------------------------------------------------------
    @ShellMethod(value = "linux的安装程序",group = "安装")
    public String yum() {
		return PrintLog2("1. 安装traceroute")+
		PrintLog4("yum install traceroute")+
		PrintLog6();
	}
    
    @ShellMethod(value = "ubuntu的安装程序",group = "安装",key = {"apt-get"})
    public String aptget() {
		return PrintLog2("1. 安装traceroute")+
		PrintLog4("apt-get install traceroute")+
		PrintLog6();
	}
    
  //-------------------------------------------------------- 执行shell ----------------------------------------------------------------------
    @ShellMethod(value = "执行shell命令,请把命令用双引号包起来",group = "linux shell")
    public void exec(String str,@ShellOption(defaultValue = "UTF-8") String charset) {
    	simpleShellCommand.execShellCmd(str, charset);
    }
    
    
    public String PrintLog(String str) {
    	return str+"\n";
    }
    public String PrintLog2(String str) {
    	return "  "+str+"\n";
    }
    public String PrintLog4(String str) {
    	return "  --"+str+"\n";
    }

    public String PrintLog5(String str) {
    	return "    ##"+str+"\n";
    }
    public String PrintLog6() {
    	return ""+"\n";
    }


    public String PrintStarLog2(String str) {
    	return "  "+str+"\n";
    }
    public String PrintStarLog4(String str) {
    	return "  **"+str+"\n";
    }

    //------------------------ version ---------------------------
    @ShellMethod(value = "版权信息",group = "版权")
    public String copyright() {    	
		return PrintLog("    	 Copyright 2022 the original author.")+
		PrintLog("    	 AleShell is licensed under the Apache License, Version 2.0")+
		PrintLog("    	 @author caizi");
	}
}
