package cn.dombro.cloudCall.dao.cloud;

import cn.dombro.cloudCall.entity.CallGrade;
import cn.dombro.cloudCall.entity.CustomerService;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f
/**
 * Author Caole
 * CreateDate: 2017/7/16
 * CreateTime: 11:40
 */
public interface CallGradeMapper {

    public CallGrade selectByPrimaryKey(Integer mId);

    public void deleteByPrimaryKey(Integer mId);

    public void insert(CallGrade callGrade);

<<<<<<< HEAD
    public void insertSelective(CallGrade callGrade) throws IOException;
=======
    public void insertSelective(CallGrade callGrade);
>>>>>>> 623a63babb5d940ee9425adac86e7094fb497b2f

    public void updateByPrimaryKeySelective(Integer mId);

    public void updateByPrimaryKey(Integer mId);
}
