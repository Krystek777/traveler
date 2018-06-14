package com.opitz.utility;

import com.opitz.repository.ClaimRepository;
import com.opitz.repository.InMemoryClaimRepository;
import com.opitz.repository.InMemoryUserRepository;
import com.opitz.repository.UserRepository;
import com.opitz.service.ClaimService;
import com.opitz.service.ClaimServiceImpl;

@Deprecated
public class ServiceLocator {

    private static ClaimService claimService = new ClaimServiceImpl();

    private static ClaimRepository claimRepository = new InMemoryClaimRepository();

    private static UserRepository userRepository = new InMemoryUserRepository();

    public static ClaimRepository findClaimRepository() {
        return claimRepository;
    }

    public static ClaimService findClaimService() {
        return claimService;
    }

    public static UserRepository findUserRepository() {
        return userRepository;

    }
}
