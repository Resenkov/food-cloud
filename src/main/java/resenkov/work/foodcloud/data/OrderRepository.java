package resenkov.work.foodcloud.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import resenkov.work.foodcloud.Taco;
import resenkov.work.foodcloud.TacoOrder;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<TacoOrder,Long> {
    List<TacoOrder> findByDeliveryCity(String city);

    List<TacoOrder> readOrdersByDeliveryCityAndCreatedAtBetween (String city, Date startDate, Date endDate);
}
