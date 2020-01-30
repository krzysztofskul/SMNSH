package pl.krzysztofskul.device.category;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceCategoryRepo extends JpaRepository<DeviceCategory, Long> {

    DeviceCategory findByCode(String code);

}
