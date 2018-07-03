package com.opitz.service;

import com.opitz.model.Claim;
import com.opitz.model.ClaimStatus;
import com.opitz.model.ClaimType;
import com.opitz.model.User;
import com.opitz.repository.ClaimRepository;
import com.opitz.repository.UserRepository;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaimServiceImplSimpleTest {

    private ClaimServiceImpl claimService;

    private List<Claim> mockClaims;

    private List<User> mockUsers;

    private ClaimRepository claimRepository;

    private UserRepository userRepository;


    @Before
    public void initialize() {
        claimService = new ClaimServiceImpl();

        mockClaims = new ArrayList<>();

        Claim claim1 = new Claim("claim1", "claimer1@claim.com", "123", ClaimType.ILLNESS,
                2, new Date(2016, 4, 4), ClaimStatus.APPROVED);
        claim1.setId(20);

        Claim claim2 = new Claim("claim2", "claimer2@claim.com", "124",
                ClaimType.ILLNESS, 1, new Date(2017, 5, 5), ClaimStatus.APPROVED);
        claim2.setId(30);

        mockUsers = new ArrayList<>();
        User user1 = new User("Bobby", "bobby@opitz.com", "0000");
        user1.setId(50);

        User user2 = new User("Johnny", "johnny@opitz.com", "1111");
        user2.setId(51);

        mockUsers.add(user1);
        mockUsers.add(user2);

        mockClaims.add(claim1);
        mockClaims.add(claim2);

        userRepository = EasyMock.createNiceMock(UserRepository.class);
        claimService.setUserRepository(userRepository);

        claimRepository = EasyMock.createNiceMock(ClaimRepository.class);
        claimService.setClaimRepository(claimRepository);

    }


    @Test
    public void test_getClaims_simple() {


        EasyMock.expect(claimRepository.getClaims()).andReturn(mockClaims);
        EasyMock.replay(claimRepository);
        List<Claim> serviceClaims = claimService.getClaims();

        assertEquals(serviceClaims, mockClaims);

    }

    @Test
    public void test_getUsers_simple() {

        EasyMock.expect(userRepository.getUsers()).andReturn(mockUsers);
        EasyMock.replay(userRepository);

        List<User> serviceUsers = claimService.getUsers();

        assertEquals(serviceUsers, mockUsers);

    }

    @Test
    public void test_saveClaim_simple() {

        Claim mockClaim = new Claim("claimX", "claimerX@claim.com", "125", ClaimType.ILLNESS,
                2, new Date(2016, 4, 4), ClaimStatus.APPROVED);
        /*expect*/ claimService.saveClaim(mockClaim);
        EasyMock.expectLastCall().once();
        EasyMock.replay(claimRepository);
        claimService.saveClaim(mockClaim);
        EasyMock.verify(claimRepository);

    }

    @Test
    public void test_saveUser_simple() {

        User mockUser= new User("mockUser1","mockuser@opitz.com", "1234");
        /*expect*/claimService.saveUser(mockUser);
        EasyMock.expectLastCall().once();
        EasyMock.replay(userRepository);
        claimService.saveUser(mockUser);
        EasyMock.verify(userRepository);

    }

    @Test
    public void test_findUserById_simple() {
        User mockUser = new User("damian", "damian@optz.com","45367");
        EasyMock.expect(userRepository.findById(4L)).andReturn(mockUser);
        EasyMock.replay(userRepository);
        User serviceUser = claimService.findUser(4L);
        assertEquals(serviceUser, mockUser);

    }


    @Test
    public void test_findUserByUsername_simple() {
        User mockUser = new User("damian", "damian@optz.com","45367");
        EasyMock.expect(userRepository.findByUsername("damian")).andReturn(mockUser);
        EasyMock.replay(userRepository);
        User serviceUser = claimService.findUser("damian");
        assertEquals(serviceUser, mockUser);


    }


    @Test
    public void testFindClaimSimple() {
        Claim mockClaim = new Claim("claimX", "claimerX@claim.com", "125", ClaimType.ILLNESS,
                2, new Date(2016, 4, 4), ClaimStatus.APPROVED);
        EasyMock.expect(claimRepository.findClaim(10L)).andReturn(mockClaim);
        EasyMock.replay(claimRepository);
        Claim serviceClaim = claimService.findClaim(10L);
        assertEquals(serviceClaim, mockClaim);

    }



}
