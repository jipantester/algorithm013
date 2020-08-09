HashMap的总结

+ hashmap的创建
```java
//建立{T --> E}的映射
Map<T,E> map = new HashMap<>();
```

+ HashMap常用的方法
  
|函数名|返回值|作用|
|--|--|--|
|put(key,value)||给哈希表赋值|
|get(key)|value|获取键值key对应的value值|
|remove(key)||删除键值为key的映射|
|isEmpty()|boolean|判空|
|getOrDefault(key,defaultvalue)|value|如存在key对应的value，则获取这个value，若不存在该key对应的value值，则将defaultvalue设置为key的对应值
|containsKey(key)|boolean|判断当前hashmap中是否包含key对应的key-value|
|containsValue(value)|boolean|判断当前hashmap中是否包含value对应的key-value|

**简介**
+ 1、HashMap是线程不安全的(HashMap是异步的，HashTable是同步的)
+ 2、HashMap采用了数组和链表的数据结构，能在查询和修改方便继承了数组的线性查找和链表的寻址修改
+ 3、HashMap是一个散列桶(数组和链表)，以键值对方式进行存储的
+ 4、HashMap是通过get()和put()方法来获取和存储对象的。当我们存储值时，将键值对传给put()方法时，他调用键的hashCode()方法来计算hashCode值，然后找到对应的bucket位置来存储对象。当获取对象时，通过调用键的equals()方法找到正确的键值对，来返回值对象
+ 5、HashMap通过链表的方式解决hash碰撞的，当发生碰撞时，对象会存储在链表的下一个节点中。

作者：初心myp
链接：https://www.jianshu.com/p/a7651fb45d96
来源：简书