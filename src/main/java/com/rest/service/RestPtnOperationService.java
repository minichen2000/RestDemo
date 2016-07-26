package com.rest.service;

import com.rest.model.NE;
import com.rest.model.PTP;
import com.rest.model.Tunnel;
import com.rest.model.TunnelCreation;

import java.util.List;

/**
 * Created by junyuel on 7/26/2016.
 */
public interface RestPtnOperationService {
    public List<NE> getAllNes();
    public List<PTP> getAllPTPs(NE ne);
    public Tunnel createTunnel(TunnelCreation data);
}
