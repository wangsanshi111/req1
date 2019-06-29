package cn.itcast.mapper;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    @Select("select * from account where accountID=#{accountID} and password=#{password}")
    public Account findByIdAndPassword(Account account);

    @Update("update account set remaining=remaining+#{money} where accountID=#{accountID}")
    public void transIn(@Param("accountID") int accountID,@Param("money") double money);

    @Update("update account set remaining=remaining-#{money} where accountID=#{accountID}")
    public void transOut(@Param("accountID") int accountID,@Param("money") double money);

    @Select("select * from account where accountID=#{accountID}")
    public Account findById(int accountID);
}
