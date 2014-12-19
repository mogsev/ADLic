package adlic;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

/**
 * @author zhenya mogsev@gmail.com
 */
public class licenses {
    private static String xmlStringPath = "src/licenses.xml";
    private static File xmlFileLicenses;
    private static Element rootNode;
    private static Element lic;
    private static Element elementkey;
    private static Element elementsum;
    private static Element productkey;
    private static Element inventsum;
    private static Element elementproduct;
    private static Element elementproductname;
    private static Element elementinvent;
    private static Element elementinventtype;
    private static Element elementkeytype;
    private static Element elementkeytypename;
    private static List listlicense;
    private static List listproduct;
    private static List listinvent;
    private static List listkey;
    private static List listsum;
    private static List listkeytype;
    private static Document document;    
    private static String product;
    private static String atr;
    private static String[] strkey;
    private static String[] strproduct;
    private static String[] strinvent;
    private static SAXBuilder builder;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JScrollPane jScrollPane2;
    private static DefaultTableModel jModelKey;
    private static DefaultTableModel jModelSum;
    
    /**
     * @see read xml file "licenses.xml"
     */
    public void readLicenses() {
        
        builder = new SAXBuilder();
        xmlFileLicenses = new File(xmlStringPath);        
        try {
            document = builder.build(xmlFileLicenses);            
            rootNode = document.getRootElement();            
            listlicense = rootNode.getChildren("license");                           
        } catch(JDOMException jdomex) {
            new javax.swing.JOptionPane(jdomex);
        } catch(IOException ioex) {
            new javax.swing.JOptionPane(ioex);
        }        
    }
    
    /**
     * @see write xml file "licenses.xml"
     */
    public void writeLicenses(Document savingDocument, String filePath) {
        try {
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            try {
                OutputStreamWriter out=new java.io.OutputStreamWriter(new java.io.FileOutputStream(filePath),"UTF-8");
                out.write(outputter.outputString(savingDocument));
                out.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            //outputter.output(savingDocument, new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    /**
     * @return xmlStringPath - возвращает путь к файлу "licenses.xml" 
     */
    public static String getFile() {
        return xmlStringPath;
    }
    
    /**
     * @return document - возвращает документ "licenses.xml"
     */
    public static Document getDocument() {
        return document;
    }
    
    /**
     * @return rootNode - static type Element from xml document 
     */
    public static Element getRootNode() {
        rootNode = document.getRootElement(); 
        return rootNode;
    }
    
    /**
     * @return list - static type List "license" from xml document 
     */
    public static List getListLicense() {
        listlicense = rootNode.getChildren("license");
        return listlicense;
    }
    
    /**    
     * @return elementkeytype - возвращает елемент "key"
     */
    public static Element getElementKeyType() {
        elementkeytype = rootNode.getChild("key");
        return elementkeytype;
    }
    
    /**     
     * @return listkeytype - возвращает список "type" в елементе "key"
     */
    public static List getListKeyType() {
        elementkeytype = rootNode.getChild("key");
        listkeytype = elementkeytype.getChildren("type");
        return listkeytype;
    }
    
    /**
     * @param numname - номер елемента "type" из списка в елементе "key"
     * @return elementproductname - возвращает елемент "name"
     */
    public static Element getElementKeyTypeName(int numname) {
        elementkeytype = rootNode.getChild("key");
        listkeytype = elementkeytype.getChildren("type");
        elementkeytypename = (Element) listkeytype.get(numname);
        return elementkeytypename;
    }
    
    /**    
     * @return elementkey - возвращает елемент "product-key"
     */
    public static Element getElementProduct() {
        elementproduct = rootNode.getChild("product-key");
        return elementproduct;
    }
    
    /**     
     * @return listproduct - возвращает список "name" в елементе "product-key"
     */
    public static List getListProduct() {
        elementproduct = rootNode.getChild("product-key");
        listproduct = elementproduct.getChildren("name");
        return listproduct;
    }
    
    /**
     * @param numname - номер елемента "name" из списка в елементе "product-name"
     * @return elementproductname - возвращает елемент "name"
     */
    public static Element getElementProductName(int numname) {
        elementproduct = rootNode.getChild("product-key");
        listproduct = elementproduct.getChildren("name");
        elementproductname = (Element) listproduct.get(numname);
        return elementproductname;
    }
    
    /**     
     * @return listinvent - возвращает елемент "invent-number"
     */
    public static Element getElementInvent() {
        elementinvent = rootNode.getChild("invent-number");
        return elementinvent;
    }
    
    /**
     * @return listinvent - возвращает список елементов "type" в елементе "invent-number"
     */
    public static List getListInvent() {
        elementinvent = rootNode.getChild("invent-number");
        listinvent = elementinvent.getChildren("type");
        return listinvent;
    }
    
    /**
     * 
     * @param numtype - номер елемента "type" из списка в елементе "invent-namber"
     * @return elementinventtype - возвращает елемент "type"
     */
    public static Element getElementInventType(int numtype) {
        elementinvent = rootNode.getChild("invent-number");
        listinvent = elementinvent.getChildren("type");
        elementinventtype = (Element) listinvent.get(numtype);
        return elementinventtype;
    }
    
    /**    
     * @param number текущий номер елемента "license"
     * @return lic елемент "license"
     */
    public static Element getElementLicense(int number) {
        lic = (Element) listlicense.get(number);
        return lic;
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return lic.getChildText("product")
     */
    public static String getProduct(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        if (lic.getChildText("product").isEmpty()) {return "";}
        else {
            return lic.getChildText("product");
        }
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return lic.getChildText("type")
     */
    public static String getType(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        return lic.getChildText("type");
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return lic.getChildText("numberlic")
     */
    public static String getNumberLic(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        return lic.getChildText("numberlic");
    }
    
    /**     
     * @param number текущий номер елемента "license"
     * @return lic.getAttributeValue(atr)
     */
    public static String getNumber(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        return lic.getAttributeValue(atr);
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @param atr атрибут елемента "license"
     * @return 
     */
    public static String getAttribute(int number, String atr) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        return lic.getAttributeValue(atr);
    }   
    
    /**
     * @param number текущий номер елемента "license" 
     * @return elementkey елемент "key"     
     */
    public static Element getElementKey(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementkey = (Element) lic.getChild("key");
        return elementkey;
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return listkey Список елементов "product-key"
     */
    public static List getListKey(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementkey = (Element) lic.getChild("key");
        listkey = elementkey.getChildren("product-key");
        return listkey;
    }
    
    /**
     * @param int текущий номер елемента "license"
     * @param numproductkey текущий номер елемента "product-key"
     * @return productkey елемент "product-key"
     */
    public static Element getElementProductKey(int number, int numproductkey) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementkey = (Element) lic.getChild("key");
        listkey = elementkey.getChildren("product-key");
        productkey = (Element) listkey.get(numproductkey);
        return productkey;
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return elementsum елемент "sum"
     */
    public static Element getElementSum(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementsum = (Element) lic.getChild("sum");
        return elementsum;
    }
    
    /**
     * @param number текущий номер елемента "license"
     * @return listsum Список елементов "invent-number"
     */
    public static List getListSum(int number) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementsum = (Element) lic.getChild("sum");
        listsum = elementsum.getChildren("invent-number");
        return listsum;
    }
    
    /**
     * @param int текущий номер елемента "license"
     * @param numproductkey текущий номер елемента "product-key"
     * @return productkey елемент "product-key"
     */
    public static Element getElementInventSum(int number, int numinventsum) {
        listlicense = rootNode.getChildren("license");
        lic = (Element) listlicense.get(number);
        elementsum = (Element) lic.getChild("sum");
        listsum = elementsum.getChildren("invent-number");
        inventsum = (Element) listsum.get(numinventsum);
        return inventsum;
    }
    
    /**
     * @param jTable1 - 
     * @param jScrollPane1 - 
     * @return jModelKey - 
     */
    public static DefaultTableModel getModelKey(javax.swing.JTable jTable1, javax.swing.JScrollPane jScrollPane1) {
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Название", "Тип", "Ключ"}
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(false);
        jTable1.setFocusable(false);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(150);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(1).setMinWidth(50);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        }
        jModelKey = (DefaultTableModel) jTable1.getModel();
        return jModelKey;
    }
    
    /**
     * @param jTable2 - 
     * @param jScrollPane2 - 
     * @return jModelSum - 
     */
    public static DefaultTableModel getModelSum(javax.swing.JTable jTable2, javax.swing.JScrollPane jScrollPane2) {
        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Название устройства", "Инвентарный номер"}
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCellSelectionEnabled(false);
        jTable2.setFocusable(false);
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTable2);
        jModelSum = (DefaultTableModel) jTable2.getModel();
        return jModelSum;
    }
    
    /**
     * @return strkeylist - список "key" - "type"
     */
    public static String[] getStrKey() {
        int i = licenses.getListKeyType().size();
        strkey = new String[i];
        for (int n=0;n<i;n++) {
            strkey[n] = licenses.getElementKeyTypeName(n).getText();            
        }
        return strkey;
    }
    
    /**
     * @return strproduct - список "product-key" - "name"
     */
    public static String[] getStrProduct() {
        int i = licenses.getListProduct().size();
        strproduct = new String[i];
        for (int n=0;n<i;n++) {
            strproduct[n] = licenses.getElementProductName(n).getText();            
        }
        return strproduct;
    }
    
    /**
     * @return strinvent - список "invent-number" - "type"
     */
    public static String[] getStrInvent() {
        int i = licenses.getListInvent().size();
        strinvent = new String[i];
        for (int n=0;n<i;n++) {
            strinvent[n] = licenses.getElementInventType(n).getText();            
        }
        return strinvent;
    }
}
