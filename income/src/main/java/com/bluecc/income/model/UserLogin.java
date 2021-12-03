package com.bluecc.income.model;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import com.google.protobuf.Message;
import com.google.protobuf.ByteString;

import com.bluecc.hubs.fund.model.IEventModel;
import static com.bluecc.hubs.ProtoTypes.*;
import com.bluecc.hubs.stub.UserLoginFlatData;

import com.bluecc.hubs.stub.UserLoginData;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin implements IEventModel<UserLoginFlatData.Builder>, Serializable {
    private static final long serialVersionUID = 1L;

    String userLoginId;
    String currentPassword;
    String passwordHint;
    Character isSystem;
    Character enabled;
    Character hasLoggedOut;
    Character requirePasswordChange;
    String lastCurrencyUom;
    String lastLocale;
    String lastTimeZone;
    java.time.LocalDateTime disabledDateTime;
    Long successiveFailedLogins;
    String externalAuthId;
    String userLdapDn;
    String disabledBy;
    java.time.LocalDateTime lastUpdatedStamp;
    java.time.LocalDateTime lastUpdatedTxStamp;
    java.time.LocalDateTime createdStamp;
    java.time.LocalDateTime createdTxStamp;
    String partyId;
    

        
    public Message toData() {
        return toDataBuilder().build();
    }

    public UserLoginFlatData.Builder toDataBuilder() {
        UserLoginFlatData.Builder builder = UserLoginFlatData.newBuilder();
        if (userLoginId != null) {
            builder.setUserLoginId(userLoginId);
        }
        if (currentPassword != null) {
            builder.setCurrentPassword(currentPassword);
        }
        if (passwordHint != null) {
            builder.setPasswordHint(passwordHint);
        }
        if (isSystem != null) {
            builder.setIsSystem(getIndicator(isSystem));
        }
        if (enabled != null) {
            builder.setEnabled(getIndicator(enabled));
        }
        if (hasLoggedOut != null) {
            builder.setHasLoggedOut(getIndicator(hasLoggedOut));
        }
        if (requirePasswordChange != null) {
            builder.setRequirePasswordChange(getIndicator(requirePasswordChange));
        }
        if (lastCurrencyUom != null) {
            builder.setLastCurrencyUom(lastCurrencyUom);
        }
        if (lastLocale != null) {
            builder.setLastLocale(lastLocale);
        }
        if (lastTimeZone != null) {
            builder.setLastTimeZone(lastTimeZone);
        }
        if (disabledDateTime != null) {
            builder.setDisabledDateTime(getTimestamp(disabledDateTime));
        }
        if (successiveFailedLogins != null) {
            builder.setSuccessiveFailedLogins(successiveFailedLogins);
        }
        if (externalAuthId != null) {
            builder.setExternalAuthId(externalAuthId);
        }
        if (userLdapDn != null) {
            builder.setUserLdapDn(userLdapDn);
        }
        if (disabledBy != null) {
            builder.setDisabledBy(disabledBy);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
        if (partyId != null) {
            builder.setPartyId(partyId);
        }
                    
        return builder;
    }

    public static UserLogin fromData(UserLoginFlatData data) {
        return UserLogin.builder()
                .userLoginId(data.getUserLoginId())
                .currentPassword(data.getCurrentPassword())
                .passwordHint(data.getPasswordHint())
                .isSystem(getIndicatorChar(data.getIsSystem()))
                .enabled(getIndicatorChar(data.getEnabled()))
                .hasLoggedOut(getIndicatorChar(data.getHasLoggedOut()))
                .requirePasswordChange(getIndicatorChar(data.getRequirePasswordChange()))
                .lastCurrencyUom(data.getLastCurrencyUom())
                .lastLocale(data.getLastLocale())
                .lastTimeZone(data.getLastTimeZone())
                .disabledDateTime(getLocalDateTime(data.getDisabledDateTime()))
                .successiveFailedLogins(data.getSuccessiveFailedLogins())
                .externalAuthId(data.getExternalAuthId())
                .userLdapDn(data.getUserLdapDn())
                .disabledBy(data.getDisabledBy())
                .lastUpdatedTxStamp(getLocalDateTime(data.getLastUpdatedTxStamp()))
                .createdTxStamp(getLocalDateTime(data.getCreatedTxStamp()))
                .partyId(data.getPartyId())
                
                .build();
    }

        
    public UserLoginData.Builder toHeadBuilder() {
        UserLoginData.Builder builder = UserLoginData.newBuilder();
        if (userLoginId != null) {
            builder.setUserLoginId(userLoginId);
        }
        if (currentPassword != null) {
            builder.setCurrentPassword(currentPassword);
        }
        if (passwordHint != null) {
            builder.setPasswordHint(passwordHint);
        }
        if (isSystem != null) {
            builder.setIsSystem(getIndicator(isSystem));
        }
        if (enabled != null) {
            builder.setEnabled(getIndicator(enabled));
        }
        if (hasLoggedOut != null) {
            builder.setHasLoggedOut(getIndicator(hasLoggedOut));
        }
        if (requirePasswordChange != null) {
            builder.setRequirePasswordChange(getIndicator(requirePasswordChange));
        }
        if (lastCurrencyUom != null) {
            builder.setLastCurrencyUom(lastCurrencyUom);
        }
        if (lastLocale != null) {
            builder.setLastLocale(lastLocale);
        }
        if (lastTimeZone != null) {
            builder.setLastTimeZone(lastTimeZone);
        }
        if (disabledDateTime != null) {
            builder.setDisabledDateTime(getTimestamp(disabledDateTime));
        }
        if (successiveFailedLogins != null) {
            builder.setSuccessiveFailedLogins(successiveFailedLogins);
        }
        if (externalAuthId != null) {
            builder.setExternalAuthId(externalAuthId);
        }
        if (userLdapDn != null) {
            builder.setUserLdapDn(userLdapDn);
        }
        if (disabledBy != null) {
            builder.setDisabledBy(disabledBy);
        }
        if (lastUpdatedTxStamp != null) {
            builder.setLastUpdatedTxStamp(getTimestamp(lastUpdatedTxStamp));
        }
        if (createdTxStamp != null) {
            builder.setCreatedTxStamp(getTimestamp(createdTxStamp));
        }
                    
        return builder;
    }

}
