package com.hq;
import java.io.File;
import java.util.*;

/**
 * 核心业务类
 */
public class Operate {
    private List<Person> list;

    public Operate(){
        DataBase database = new DataBase();
        String file = System.getProperty("user.dir")+"/database.txt";
        if(new File(file).exists()){
            this.list = database.readData(file);
        }else {
            this.list = new ArrayList<>();
        }
    }
    /**
     * 添加记录业务逻辑控制
     */
    public void addLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true) {
            menu.addMenu();
            int item = regex.menuItemValidate(1, 3);
            switch (item) {
                case 1:
                    addOperation();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    return;
            }
        }
    }
    /**
     * 修改记录业务逻辑控制
     */
    public void modifyLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.modifyMenu();
            int item = regex.menuItemValidate(1,3);
            switch(item){
                case 1:
                    showAll();break;
                case 2:
                    modifyOperation();break;
                case 3:
                    return;
            }
        }
    }
    /**
     * 查询记录业务逻辑控制
     */
    public void searchLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true){
            menu.searchMenu();
            int item = regex.menuItemValidate(1,7);
            switch (item){
                case 1:
                    searchByName();break;
                case 2:
                    searchByAge();break;
                case 3:
                    searchBySex();break;
                case 4:
                    searchByTelNum();break;
                case 5:
                    searchByAddress();break;
                case 6:
                    showAll();break;
                case 7:
                    return;
            }
        }
    }
    /**
     * 删除记录业务逻辑控制
     */
    public void deleteLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true) {
            menu.deleteMenu();
            int item = regex.menuItemValidate(1, 4);
            switch (item) {
                case 1:
                    showAll();break;
                case 2:
                    deleteOperation();break;
                case 3:
                    deleteAllOperation();break;
                case 4:
                    return;
            }
        }
    }
    /**
     * 排序记录业务逻辑控制
     */
    public void orderLogic(){
        Menu menu = new Menu();
        TelNoteRegex regex = new TelNoteRegex();
        while(true) {
            menu.orderMenu();
            int item = regex.menuItemValidate(1, 5);
            switch (item) {
                case 1:
                    orderByName();break;
                case 2:
                    orderByAge();break;
                case 3:
                    orderBySex();break;
                case 4:
                    showAll();break;
                case 5:
                    return;
            }
        }
    }
    /**
     * 添加新记录信息
     */
    public void addOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        String age = regex.ageValidate();
        String sex = regex.sexValidate();
        String telNum = regex.telNumValidate();
        String address = regex.addressValidate();
        Person person = new Person(name, age, sex, telNum, address);
        this.list.add(person);
        person.setId(this.list.size());
        System.out.println("新记录添加成功!");
    }
    /**
     * 查询全部记录
     */
    public void showAll(){
        if(this.list.size() == 0) {
            System.out.println("电话本没有任何记录!");
        }else{
            for (Person person : this.list) {
                System.out.println(person);
            }
        }
    }
    /**
     * 按姓名查询记录
     */
    public void searchByName(){
        TelNoteRegex regex = new TelNoteRegex();
        String name = regex.nameValidate();
        Person person = null;
        for(Person per:this.list) {
            if (name.equals(per.getName())) {
                person = per;
                break;
            }
        }
        if(person == null){
            System.out.println("没有该条记录");
        }else{
            System.out.println(person);
        }
    }
    /**
     * 按年龄查询记录
     */
    public void searchByAge(){
        TelNoteRegex regex = new TelNoteRegex();
        String age = regex.ageValidate();
        boolean flag = true;
        for(Person per:this.list) {
            if (age.equals(per.getAge())) {
                System.out.println(per);
                flag = false;
            }
        }
        if(flag) {
            System.out.println("没有该年龄的记录");
        }
    }
    /**
     * 按性别查询记录
     */
    public void searchBySex(){
        TelNoteRegex regex = new TelNoteRegex();
        String sex = regex.sexValidate();
        boolean flag = true;
        for(Person per:this.list) {
            if (sex.equalsIgnoreCase(per.getSex())) {
                System.out.println(per);
                flag = false;
            }
        }
        if(flag) {
            System.out.println("没有该性别的记录");
        }
    }
    /**
     * 按电话号码查询记录
     */
    public void searchByTelNum(){
        TelNoteRegex regex = new TelNoteRegex();
        String telNUm = regex.telNumValidate();
        boolean flag = true;
        for(Person per:this.list) {
            if (telNUm.equals(per.getTelNum())) {
                System.out.println(per);
                flag = false;
            }
        }
        if(flag) {
            System.out.println("没有该电话号码的记录");
        }
    }
    /**
     * 按地址查询记录
     */
    public void searchByAddress(){
        TelNoteRegex regex = new TelNoteRegex();
        String address = regex.addressValidate();
        boolean flag = true;
        for(Person per:this.list) {
            if (address.equals(per.getAddress())) {
                System.out.println(per);
                flag = false;
            }
        }
        if(flag) {
            System.out.println("没有该地址的记录");
        }
    }
    /**
     * 修改指定记录
     */
    public void modifyOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        Menu menu = new Menu();
        System.out.println("请输入想要修改记录的序号:");
        int itemNum = regex.menuItemValidate(1,this.list.size()) - 1;
        while(true){
            menu.subModifyMenu();
            int menuItem = regex.menuItemValidate(1,6);
            switch(menuItem){
                case 1:
                    String name = regex.nameValidate();
                    this.list.get(itemNum).setName(name);
                    System.out.println("修改成功！");
                    break;
                case 2:
                    String age = regex.ageValidate();
                    this.list.get(itemNum).setAge(age);
                    System.out.println("修改成功！");
                    break;
                case 3:
                    String sex = regex.sexValidate();
                    this.list.get(itemNum).setSex(sex);
                    System.out.println("修改成功！");
                    break;
                case 4:
                    String telNum = regex.telNumValidate();
                    this.list.get(itemNum).setTelNum(telNum);
                    System.out.println("修改成功！");
                    break;
                case 5:
                    String address = regex.addressValidate();
                    this.list.get(itemNum).setAddress(address);
                    System.out.println("修改成功！");
                    break;
                case 6:
                    return;
            }
        }
    }
    /**
     * 删除指定记录
     */
    public void deleteOperation(){
        TelNoteRegex regex = new TelNoteRegex();
        System.out.println("请输入想要删除记录的序号:");
        int itemNum = regex.menuItemValidate(1,this.list.size()) - 1;
        this.list.remove(itemNum);
        //重新为记录设置序号
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
        System.out.println("删除成功！");
    }
    /**
     * 删除全部记录
     */
    public void deleteAllOperation(){
        this.list.clear();
        System.out.println("电话本已清空！");
    }
    /**
     * 按照姓名排序记录
     */
    public void orderByName(){
        Collections.sort(this.list,new OrderByName());
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
        System.out.println("按姓名排序成功！");
    }
    /**
     * 按照年龄排序记录
     */
    public void orderByAge(){
        Collections.sort(this.list,new OrderByAge());
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
        System.out.println("按年龄排序成功！");
    }
    /**
     * 按照性别排序记录
     */
    public void orderBySex(){
        Collections.sort(this.list,new OrderBySex());
        for(int i=0;i<this.list.size();i++){
            this.list.get(i).setId(i+1);
        }
        System.out.println("按性别排序成功！");
    }

    /**
     * 用于退出程序
     */
    public void exit(){
        DataBase dataBase = new DataBase();
        String file = System.getProperty("user.dir")+"/database.txt";
        dataBase.writeData(file,this.list);
        System.exit(0);
    }
    /**
     * 按姓名排序的比较器
     */
    class OrderByName implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    /**
     * 按年龄排序的比较器
     */
    class OrderByAge implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            int o1Age = Integer.parseInt(o1.getAge());
            int o2Age = Integer.parseInt(o2.getAge());
            return o1Age - o2Age;
        }
    }
    /**
     * 按性别排序的比较器
     */
    class OrderBySex implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getSex().toLowerCase().compareTo(o2.getSex().toLowerCase());
        }
    }
}
