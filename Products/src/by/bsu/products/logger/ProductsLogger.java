//package by.bsu.products.logger;
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package by.bsu.produts.logger;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.Properties;
//import org.apache.log4j.Logger;
//import org.apache.log4j.WriterAppender;
//import org.apache.log4j.xml.XMLLayout;
//
///**
// *
// * @author Katsiaryna_Homyakova
// */
//public final class ProductsLogger {
//
//    private static ProductsLogger instance;
//    private static Logger logger;
//    private static XMLLayout layout = new XMLLayout();
//
//    public static ProductsLogger getInstance(Class msgSender) {
//        if (instance == null) {
//            logger = Logger.getLogger(msgSender);
//            WriterAppender appender = null;
//            Properties prop = new Properties();
//            String fileName = null;
//            try {
//                prop.load(ProductsLogger.class.getClassLoader().getResourceAsStream("config.properties"));
//                fileName = prop.getProperty("fileNameLog");
//                File f = new File(fileName);
//                FileOutputStream output = new FileOutputStream(f);
//                appender = new WriterAppender(layout, output);
//                logger.addAppender(appender);
//                instance = new ProductsLogger();
//            } catch (Exception e) {
//            }
//        }
//        return instance;
//    }
//
//    public void writeError(String message) {
//        logger.error(message);
//    }
//}
