package com.marathon.service.worditem;

import com.marathon.domain.MrtonWordItem;

import java.util.List;

public interface WordItemService {

    List<MrtonWordItem> getWordItem(String mrtonProcId);

}
