package pl.krzysztofskul.device.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysztofskul.device.Device;

import java.util.List;

@Service
@Transactional
public class DeviceCategoryService {

    private DeviceCategoryRepo deviceCategoryRepo;

    @Autowired
    public DeviceCategoryService(
            DeviceCategoryRepo deviceCategoryRepo
    ) {
        this.deviceCategoryRepo = deviceCategoryRepo;
    }

    /***
     * METHODS: CRUD
     */

    public void save(DeviceCategory deviceCategory) {
        deviceCategoryRepo.save(deviceCategory);
    }

    public List<DeviceCategory> loadAll() {
        return deviceCategoryRepo.findAll();
    }

    public DeviceCategory loadByCode(String code) {
        return deviceCategoryRepo.findByCode(code);
    }

    /***
     * METHODS: ADD/REMOVE DEVICE
     */

    public void addDeviceToCategory(DeviceCategory deviceCategory, Device device) {
        List<Device> deviceList = deviceCategory.getDeviceList();
        deviceList.add(device);
        deviceCategory.setDeviceList(deviceList);
    }

    public void removeDeviceFromCategory(DeviceCategory deviceCategory, Device device) {
        List<Device> deviceList = deviceCategory.getDeviceList();
        deviceList.remove(device);
        deviceCategory.setDeviceList(deviceList);
    }

    /***
     * NO CRUD METHODS
     */

    public boolean isExistent(String value) {
        List<DeviceCategory> deviceCategoryList = deviceCategoryRepo.findAll();

        if (deviceCategoryList.size() != 0) {
            for (DeviceCategory deviceCategory : deviceCategoryList) {
                if (deviceCategory.getCode().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

}
