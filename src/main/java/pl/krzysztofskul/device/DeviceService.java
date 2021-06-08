package pl.krzysztofskul.device;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeviceService {

    /**
     * params.
     */

    private DeviceRepo deviceRepo;

    /**
     * constr.
     * @param deviceRepo
     */
    @Autowired
    public DeviceService(DeviceRepo deviceRepo) {
        this.deviceRepo = deviceRepo;
    }

    /**
     * methods CRUD
     * */

    /*** Create */

    public void save(Device device) {
        deviceRepo.save(device);
    }

    /*** Read */

    public List<Device> loadAll() {
        return deviceRepo.findAll();
    }

    public Device loadById(Long id) {
        return deviceRepo.findById(id).get();
    }

    public Device loadByIdWithConfigurationList(Long id) {
        Device device = this.loadById(id);
        Hibernate.initialize(device.getConfigurationList());
        return device;
    }

    /*** Update*/

    /*** Delete */
}
