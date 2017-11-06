package com.zjcds.xa.common.utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class GetWebservice {

    public static void main(String[] args) {

        String url = "";
        url = "http://localhost:8080/web_service_server/servlet/HelloWorld?wsdl";
        Object[] obj =new Object[]{20,50};
        try {
            String targetEendPoint =  "http://localhost:8080/axis/HelloAXIS.jws" ;
            Service service =  new  Service();
            Call call = (Call) service.createCall();
            call.setOperationName( new QName(targetEendPoint,  "Hello" ));
            call.setTargetEndpointAddress( new URL(targetEendPoint));
            String result = (String) call.invoke( new  Object[]{ "Robert" });
            System.out.println(result);
        }  catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    }
