package apiengine;

import org.testng.Assert;

import com.apiautomation.model.ResponseObject;
import com.apiautomation.model.request.RequestObject;

public class TaskAssertion {
    public void AssertAddObject(ResponseObject responseObject, RequestObject requestObject){
    Assert.assertEquals(responseObject.name, requestObject.name);
    Assert.assertEquals(responseObject.dataItem.year, requestObject.data.year);
    Assert.assertEquals(responseObject.dataItem.price, requestObject.data.price);
    Assert.assertEquals(responseObject.dataItem.cpuModel, requestObject.data.CPUmodel);
    Assert.assertEquals(responseObject.dataItem.hardDiskSize, requestObject.data.HardDiskSize);
    }
}
