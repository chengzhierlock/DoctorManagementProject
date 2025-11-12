package org.example.java142_project.common.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import org.example.java142_project.common.util.ViewUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//加载所以页面到缓存map<,>
//根据键值切换页面，根据所需要显示的页面放在观察者列表中
public class UIMyManager {
        private static Map<UIConstant,Object> nodeMap = new HashMap<>();
        public static void initView() {
            UIConstant[] values = UIConstant.values();
            for(UIConstant u : values){
                String viewUrl = u.toString();
                if(u.getLoadType() == LoadType.EAGER) {
//                    立即加载
                    try {
                        Parent root = FXMLLoader.load(UIMyManager.class.getResource(viewUrl));
                        nodeMap.put(u,root);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    nodeMap.put(u,viewUrl);
                }
            }
        }

        public static void show(ObservableList<Node> nodeList, UIConstant uiConstant) {
//            清除观察者列表
            nodeList.clear();
            Node node = null;
            if(uiConstant.getLoadType() == LoadType.EAGER) {
                node = (Node)nodeMap.get(uiConstant);
            } else {
                String viewUrl = (String)nodeMap.get(uiConstant);
                try {
                    node = FXMLLoader.load(UIMyManager.class.getResource(viewUrl));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            nodeList.add(node);
        }

}
