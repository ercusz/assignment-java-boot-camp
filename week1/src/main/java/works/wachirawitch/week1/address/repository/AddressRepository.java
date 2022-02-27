package works.wachirawitch.week1.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
