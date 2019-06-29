package cn.itcast.mapper;

import cn.itcast.domain.Trade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface TradeMapper {
    @Select("select * from trade where tradetime between #{begin} and #{end} and accountID=#{accountID};")
    public List<Trade> findByDate(@Param("begin") Date begin,@Param("end") Date end, @Param("accountID")int accountID);

    @Insert("insert into trade values (null,#{accountID},#{tradetype},#{trademoney},#{tradetime},#{tradedigest});")
    public void save(Trade trade);
}
