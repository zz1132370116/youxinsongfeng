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
            //用于判断是否应该结束这一次循环
            int temp = 0;

            //获取一级分类
            if (classification.getClassificationParent() .equals("0") ){
                classificationList.add(classification);
                temp = 1;
            }

            //获取二级分类
            for (Classification first: classificationList) {
                if (temp == 1){
                    break;
                }
                if (Integer.parseInt(classification.getClassificationParent()) == first.getClassificationId()){
                    classificationList2.add(classification);
                    if (first.getClassification() == null){
                        List<Classification> firstChild = new ArrayList<>();
                        first.setClassification(firstChild);
                    }
                    first.getClassification().add(classification);
                    temp = 1;
                    break;
                }
            }


            //获取三级分类
            for (Classification second : classificationList2) {
                if (temp == 1){
                    break;
                }
                //找到三级
                if (Integer.parseInt(classification.getClassificationParent()) == second.getClassificationId()){
                    classificationList3.add(classification);
                    if (second.getClassification() == null){
                        List<Classification> secondChild = new ArrayList<>();
                        second.setClassification(secondChild);
                    }
                    second.getClassification().add(classification);
                    break;
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

        System.out.println(classificationList);

        return classifications;
    }
}
