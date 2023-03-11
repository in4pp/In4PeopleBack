package com.in4people.bootrestapi.personnel.service;

import com.in4people.bootrestapi.approval.entity.Approval;
import com.in4people.bootrestapi.common.Criteria;
import com.in4people.bootrestapi.personnel.dto.CertificateDTO;
import com.in4people.bootrestapi.personnel.entity.Certificate;
import com.in4people.bootrestapi.personnel.entity.PerOrderApp;
import com.in4people.bootrestapi.personnel.repository.OrderInfoRepository;
import com.in4people.bootrestapi.personnel.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonnelService {

    private static final Logger log = LoggerFactory.getLogger(PersonnelService.class);

    private final PersonnelRepository personnelRepository;

    private final OrderInfoRepository orderInfoRepository;

    private final ModelMapper modelMapper;

    public Object selectCerInfo(String cerCode) {

        Certificate certificate = personnelRepository.findByCerCode(cerCode);
        log.info("[PersonnelService] {}", certificate);

        return modelMapper.map(certificate, CertificateDTO.class);
    }

    public int selectOrderInfoTotal() {

        log.info("[PersonnelService] selectOrderInfoTotal start ============================ ");

        List<Approval> orderInfoList = orderInfoRepository.findByDocTypeAndIsApproved("인사발령", "Y");

        log.info("[PersonnelService] selectOrderInfoTotal end ============================ ");
        log.info("[orderInfoList count] >>>>>>>>>>>>> " , orderInfoList);
        return orderInfoList.size();
    }

    public Object selectOrderInfoListWithPaging(Criteria cri) {

        log.info("[PersonnelService] selectOrderInfoListWithPaging start ============================ ");

        int index = cri.getPageNum() - 1;

        int count = cri.getAmount();

        Pageable paging = PageRequest.of(index, count, Sort.by("docCode").descending());
        log.info("[orderInfoList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 야호");
        Page<Approval> result = orderInfoRepository.findByDocTypeAndIsApproved("인사발령","Y", paging);

        List<Approval> orderInfoList = result.getContent();
        log.info("[orderInfoList] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + result.getContent() );
        log.info("[PersonnelService] selectOrderInfoListWithPaging end ============================ ");

        return orderInfoList.stream().map(orderInfo -> modelMapper.map(orderInfo, Approval.class)).collect(Collectors.toList());

    }

}
