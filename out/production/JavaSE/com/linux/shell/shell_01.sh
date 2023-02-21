#!/bin/bash

# shell变量
  #变量名和等号之间不能有空格
  #命名只能使用英文字母，数字和下划线，首个字符不能以数字开头
  #中间不能有空格，可以使用下划线 _
  #不能使用标点符号
  #不能使用bash里的关键字（可用help命令查看保留关键字）
your_name="wangle"
  #使用变量 变量名外面的花括号是可选的，加不加都行，加花括号是为了帮助解释器识别变量的边界
echo $your_name
echo ${your_name}
echo ${your_name} is beauty
  #只读变量 使用readonly 命令可以将变量定义为只读变量，只读变量的值不能被改变
myUrl="https://www.google.com"
readonly myUrl
  #删除变量 使用unset命令可以删除变量 变量被删除之后不能在使用，不能删除只读变量
unset your_name
  #变量类型
    #局部变量 局部变量在脚本或命令中定义，仅在当前shell实例中有效，其他shell启动的程序不能访问局部变量
    #环境变量 所有的程序，包括shell启动的程序，都能访问环境变量，有些程序需要环境变量来保证其正常运行。必要的时候shell脚本也可以定义环境变量
    #shell变量 shell变量是由shell程序设置的特殊变量。shell变量中有一部分是环境变量，有一部分是局部变量，这些变量保证了shell的正常运行

  #Shell字符串 字符串是shell编程中最常用最有用的数据类型（除了数字和字符串，也没啥其它类型好用了），字符串可以用单引号，也可以用双引号，也可以不用引号
    #单引号
      #单引号字符串的限制：
        #单引号里的任何字符都会原样输出，单引号字符串中的变量是无效的；
        #单引号字串中不能出现单独一个的单引号（对单引号使用转义符后也不行），但可成对出现，作为字符串拼接使用。
your_name='runoob'
    #双引号
      #双引号里可以有变量
      #双引号里可以出现转义字符
your_name="runoob"
result="Hello, I know you are \"$your_name\"! \n"
echo -e $result
      #使用单引号拼接
greeting_2='hello, '$your_name' !'
greeting_3='hello, ${your_name} !'
echo $greeting_2  $greeting_3
      #使用双引号拼接
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting  $greeting_1
      #获取字符串长度
string="abcd"
echo ${#string}









