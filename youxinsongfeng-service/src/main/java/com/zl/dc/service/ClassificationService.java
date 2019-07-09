package com.zl.dc.service;

import com.zl.dc.entity.Classification;
import com.zl.dc.mapper.ClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: 舌頭會游泳
 * @Date: 2019/7/8 19:50
 * @Description:
 */
@Service
@Transactional
public class ClassificationService {
    @Autowired
    private ClassificationMapper classificationMapper;

    public List<Classification> findClassifications() {
        //一级分类
        List<Classification> classificationList =new ArrayList<>();
        //二级分类
        List<Classification> classificationList2 =new ArrayList<>();
        //三级分类
        List<Classification> classificationList3 =new ArrayList<>();
        //查询分类
        List<Classification> classifications = classificationMapper.selectAll();
        for (Classification classification : classifications) {
            if (classification.getClassificationParent() .equals("0") ){
                classificationList.add(classification);
            }else{
                //遍历一级分类
                for (Classification classification1 : classificationList) {
                    //找到所有二级分类
                    if (Integer.parseInt(classification.getClassificationParent()) == classification1.getClassificationId()){
                        classificationList2.add(classification);
                        classification1.setClassification(classificationList2);
                    }else{
                        //遍历二级分类
                        for (Classification classification2 : classificationList2) {
                            //找到三级
                            if (Integer.parseInt(classification.getClassificationParent()) == classification2.getClassificationId()){
                                classificationList3.add(classification);
                                classification2.setClassification(classificationList3);
                            }
                        }
                    }
                }
            }
        }
        Iterator<Classification> iterator = classifications.iterator();
        while(iterator.hasNext()){
            Classification next = iterator.next();
            //不是一级
            if (!next.getClassificationParent().equals("0")){
                //删除
                iterator.remove();
            }
        }

        return classifications;
    }
}
