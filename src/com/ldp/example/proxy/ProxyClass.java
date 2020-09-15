package com.ldp.example.proxy;

/**
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * <p>
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 */
public class ProxyClass {

    public interface IImage {
        void startPlay();
    }

    public static class imageLoad implements IImage {

        private String imageFileName;

        public imageLoad(String imageFileName) {
            this.imageFileName = imageFileName;
            loadFromDisk(imageFileName);
        }

        private void loadFromDisk(String imageFileName) {
            System.out.println("Loading" + imageFileName);
        }

        @Override
        public void startPlay() {
            System.out.println(imageFileName + "  展示出来");
        }
    }

    public static class imageLoadProxy implements IImage {

        private String imageFileName;
        private imageLoad imageLoad;

        public imageLoadProxy(String imageFileName) {
            this.imageFileName = imageFileName;
        }

        @Override
        public void startPlay() {
            if (imageLoad == null)
                imageLoad = new imageLoad(imageFileName);
            imageLoad.startPlay();
        }
    }

    public static void main(String[] args) {
        imageLoadProxy imageLoadProxy = new imageLoadProxy("test.jpg");
        // 图像将从磁盘加载
        imageLoadProxy.startPlay();
        // 图像不需要从磁盘加载
        imageLoadProxy.startPlay();
    }

}
