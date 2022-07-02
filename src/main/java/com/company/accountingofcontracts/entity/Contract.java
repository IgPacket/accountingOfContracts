package com.company.accountingofcontracts.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.annotation.DeletedBy;
import io.jmix.core.annotation.DeletedDate;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDelete;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "CONTRACT")
@Entity
public class Contract {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATE_OF_CONCLUSION", nullable = false)
    @NotNull
    private LocalDate dateOfConclusion;

    @Column(name = "TERM_OF_THE_CONTRACT", nullable = false)
    @NotNull
    private LocalDate termOfTheContract;

    @Column(name = "AMOUNT_OF_SERVICES", nullable = false, precision = 19, scale = 3)
    @NotNull
    private BigDecimal amountOfServices;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "contracts")
    private List<Client> customer;

    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToMany(mappedBy = "contract")
    private List<Contractor> executor;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @DeletedBy
    @Column(name = "DELETED_BY")
    private String deletedBy;

    @DeletedDate
    @Column(name = "DELETED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public List<Contractor> getExecutor() {
        return executor;
    }

    public void setExecutor(List<Contractor> executor) {
        this.executor = executor;
    }

    public List<Client> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Client> customer) {
        this.customer = customer;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public BigDecimal getAmountOfServices() {
        return amountOfServices;
    }

    public void setAmountOfServices(BigDecimal amountOfServices) {
        this.amountOfServices = amountOfServices;
    }

    public LocalDate getTermOfTheContract() {
        return termOfTheContract;
    }

    public void setTermOfTheContract(LocalDate termOfTheContract) {
        this.termOfTheContract = termOfTheContract;
    }

    public LocalDate getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(LocalDate dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}