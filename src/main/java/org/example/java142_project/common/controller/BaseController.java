package org.example.java142_project.common.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BaseController {

    public void colToProper(Class clazz){
        // 1 反射 获取当前类成员属性  TableColumn getType
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            try{
                //判断属性是不是TableColumn
                if(TableColumn.class.isAssignableFrom(field.getType())){
                    field.setAccessible(true);
                    //获取属性值  对象
                    TableColumn column = (TableColumn)field.get(this);
                    //获取实体对象中的属性 idCol loginnameCol
                    String fieldName = field.getName();
                    if(fieldName.endsWith("Col")){
                        // id  loginname  realname qq birthday email
                        fieldName = fieldName.substring(0,fieldName.length()-3);
                        // 2 获取构造方法 参数
                        Constructor constructor = PropertyValueFactory.class.getConstructor(String.class);
                        // 创建对象  new PropertyValueFactory<>("loginname")
                        Object obj = constructor.newInstance(fieldName);
                        // 3 调用方法  invoke setCellValueFactory
                        //import javafx.util.Callback;
                        Method f1 = TableColumn.class.getDeclaredMethod("setCellValueFactory", Callback.class);
                        // 4 创建对象 作为参数
                        f1.invoke(column,obj);
                    }
                }
            }catch(Exception e){
            }
        }

    }
    //将文本框中数据  --》转换为对象
    // 一个参数 Controller  对象
    public <T> T createObject(Class clazz,Class objCls){
        Field[] txtFields = clazz.getDeclaredFields();
        Field[] objFields = objCls.getDeclaredFields();
        Object obj = null;
        try {
            //
            obj = objCls.newInstance();
            //Controller类中的文本框
            for(Field field:txtFields){
                if(TextField.class.isAssignableFrom(field.getType())){
                    //获取对象
                    TextField textObj = (TextField)field.get(this);
                    //对象的值  文本框中的值
                    String val= textObj.getText();
                    //遍历实体类的所有属性
                    for(Field objField:objFields){
                        objField.setAccessible(true);
                        if(field.getName().contains(objField.getName())&&field.getName().endsWith("Ref")){
                            if(objField.getType()==int.class){
                                objField.set(obj,Integer.parseInt(val));
                            }else if(objField.getType()==double.class){
                                objField.set(obj,Double.parseDouble(val));
                            }else{
                                //给实体类对象赋值
                                objField.set(obj,val);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (T) obj;
    }
}
//