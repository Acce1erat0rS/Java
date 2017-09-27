JavaEX
===
HelloJava
---
This is my first java program, which implements a senorial where given a light matrix and a sequence of commands. Where each command consturct the matrix to do a series of jobs. At the end of the program, number of odd light column is outputed. The command are excuted as follows.

> * 对每一盏灯的操作都是使其状态反转；
> * 如果自上往下，则上面一行的某盏灯的反转会触发下一行中一盏（恰好一盏）灯的反转；如果自下向上，则下面一行的某盏灯的反转会触发上一行中一盏（恰好一盏）灯的反转；
> * 施加一个反转序列的操作会影响所有的行，每行只反转一盏灯；
> * 多米诺光控灯阵列可以生成一行摘要信息，这行摘要信息也是一行灯，灯的灭与亮是由这列上所有灯的状态决定的。如果相应列上的亮灯总数是奇数，则指示灯是亮的；如果相应列上亮灯总数是偶数，则指示灯灭的。
> * 最后要输出指示灯亮的总数量。

Inorder to compress the matrix into the 200MB memory limit, we use a Long Int to represent a row.

fastLight
---
Actually there is a better way to solve the first problem.

As each turn will change the parity of each column, we simply needs a LongInt to track the parity of each column. Where the F dosen't matter as well.
