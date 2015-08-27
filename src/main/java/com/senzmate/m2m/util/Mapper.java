package com.senzmate.m2m.util;

import com.senzmate.m2m.document.HistoryDocument;
import com.senzmate.m2m.table.History;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static List<HistoryDocument> convertHistoryTableToDocumentList(List<History> historyList) {
        List<HistoryDocument> historyDocumentListList=new ArrayList<HistoryDocument>();
        HistoryDocument historyDocument;
        for(History history:historyList){
            historyDocument=new HistoryDocument();
            BeanUtils.copyProperties(history,historyDocument);
            historyDocumentListList.add(historyDocument);
        }
        return historyDocumentListList;
    }

    public static History convertDeviceDocumentToTable(HistoryDocument historyDocument) {
        History history = new History();
        BeanUtils.copyProperties(historyDocument, history);
        return history;
    }
}
