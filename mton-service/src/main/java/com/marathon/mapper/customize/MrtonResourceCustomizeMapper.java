package com.marathon.mapper.customize;

import com.marathon.qvo.ceremony.PreviewData;

import java.util.List;

public interface MrtonResourceCustomizeMapper {

    List<PreviewData> getRelatedResource(String procName);

}
