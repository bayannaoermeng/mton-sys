package com.marathon.service.worditem.impl;

import com.marathon.domain.MrtonWordItem;
import com.marathon.domain.MrtonWordItemExample;
import com.marathon.mapper.MrtonWordItemMapper;
import com.marathon.service.worditem.WordItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cuiguangqiang
 * @version WordItemServiceImpl, v0.1 2020/5/5 10:28
 * @description 类说明
 */
@Slf4j
@Service
public class WordItemServiceImpl implements WordItemService {

    @Autowired
    private MrtonWordItemMapper mrtonWordItemMapper;

    @Override
    public List<MrtonWordItem> getWordItem(String mrtonProcId) {

        MrtonWordItemExample example = new MrtonWordItemExample();
        example.or().andProcIdEqualTo(mrtonProcId);

        return mrtonWordItemMapper.selectByExample(example);
    }
}
