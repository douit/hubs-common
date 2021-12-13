package com.bluecc.saga.common;

import com.bluecc.hubs.fund.model.IModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DataListWrapper implements IMessageEvent{
    List<? extends IModel<?>> data;
}
