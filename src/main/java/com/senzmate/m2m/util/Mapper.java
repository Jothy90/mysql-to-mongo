package com.senzmate.m2m.util;

import com.senzmate.m2m.document.DeviceDocument;
import com.senzmate.m2m.document.HistoryDocument;
import com.senzmate.m2m.table.Device;
import com.senzmate.m2m.table.History;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    public List<DeviceDocument> convertDeviceTableToDocumentList(List<Device> deviceList) {
        List<DeviceDocument> deviceDocumentListList=new ArrayList<DeviceDocument>();
        DeviceDocument deviceDocument;
        for(Device device:deviceList){
            deviceDocument=new DeviceDocument();
            BeanUtils.copyProperties(device,deviceDocument);
            deviceDocumentListList.add(deviceDocument);
        }
        return deviceDocumentListList;
    }
    public List<HistoryDocument> convertHistoryTableToDocumentList(List<History> historyList) {
        List<HistoryDocument> historyDocumentListList=new ArrayList<HistoryDocument>();
        HistoryDocument historyDocument;
        for(History history:historyList){
            historyDocument=new HistoryDocument();
            BeanUtils.copyProperties(history,historyDocument);
            historyDocumentListList.add(historyDocument);
        }
        return historyDocumentListList;
    }

    public Device convertDocumentToDevice(DeviceDocument deviceDocument) {
        Device device = new Device();
        BeanUtils.copyProperties(deviceDocument, device);
        return device;
    }


}
