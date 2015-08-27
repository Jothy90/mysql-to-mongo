package com.senzmate.m2m.util;

import com.senzmate.m2m.document.HistoryDocument;
import com.senzmate.m2m.table.History;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

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

    public History convertDeviceDocumentToTable(HistoryDocument historyDocument) {
        History history = new History();
        BeanUtils.copyProperties(historyDocument, history);
        return history;
    }
}
