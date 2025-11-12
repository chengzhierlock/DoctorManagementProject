package org.example.java142_project.common.ui;
//所有页面的常量
public enum  UIConstant {
    DOC_ADD(LoadType.LAZY) {
        @Override
        public String toString() {
            return "/org/example/java142_project/doctoradd.fxml";
        }
    },
    DOC_SET(LoadType.LAZY) {
        @Override
        public String toString() {
            return "/org/example/java142_project/doctorset.fxml";
        }
    };

    private LoadType loadType;
    UIConstant(LoadType loadType) {
        this.loadType = loadType;
    }

    public LoadType getLoadType() {
        return loadType;
    }

    public void setLoadType(LoadType loadType) {
        this.loadType = loadType;
    }
}
