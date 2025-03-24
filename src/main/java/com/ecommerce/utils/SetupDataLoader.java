package com.ecommerce.utils;

import com.ecommerce.entities.Privilege;
import com.ecommerce.entities.Role;
import com.ecommerce.enums.AccountRoleEnum;
import com.ecommerce.enums.PrivilegeEnum;
import com.ecommerce.repositories.PrivilegeRepository;
import com.ecommerce.repositories.RoleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final PrivilegeRepository privilegeRepository;

    boolean alreadySetup = false;

    @Override
    public void onApplicationEvent(@NonNull ContextRefreshedEvent event) {
        PrivilegeEnum[] privilegeEnums = PrivilegeEnum.values();
        AccountRoleEnum[] accountRoleEnums = AccountRoleEnum.values();
        if (alreadySetup) return;
        for (PrivilegeEnum privilegeEnum : privilegeEnums) {
            createPrivilegeIfNotExist(privilegeEnum);
        }
        for (AccountRoleEnum role : accountRoleEnums) {
            createRoleIfNotExist(role);
        }
        alreadySetup = false;
    }

    private void createRoleIfNotExist(AccountRoleEnum roleName) {
        List<Role> roleList = new ArrayList<>();
        Optional<Role> getRole = roleRepository.findByName(roleName);
        if (getRole.isEmpty()) {
            Role role = Role.builder()
                    .name(roleName)
                    .build();
            roleList.add(role);
        }
        roleRepository.saveAll(roleList);

    }

    void createPrivilegeIfNotExist(PrivilegeEnum privilegeEnum) {
        List<Privilege> privilegeList = new ArrayList<>();
        Optional<Privilege> getPrivileges = privilegeRepository.findByName(privilegeEnum);
        if (getPrivileges.isEmpty()) {
            Privilege privilege = Privilege.builder()
                    .name(privilegeEnum)
                    .build();
            privilegeList.add(privilege);
        }
        privilegeRepository.saveAll(privilegeList);
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }


}
