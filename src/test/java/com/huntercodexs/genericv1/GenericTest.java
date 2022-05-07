package com.huntercodexs.genericv1;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenericTest extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    /**
     * Create Item
     */

    @Test
    public void whenRequestToCreateItemButNoBody_RetrieveMissingBodyRequest_409() throws Exception {
        boolean skip = true;
        if (!skip) {
            conflictByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-no-body"));
        }
    }

    @Test
    public void whenRequestToCreateItemButNoBodyData_RetrieveMissingBodyRequest_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-no-body-data"));
    }

    @Test
    public void whenRequestToCreateItemButNoItemName_RetrieveMissingItemName_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-no-itemname"));
    }

    @Test
    public void whenRequestToCreateItemButNoName_RetrieveMissingName_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-no-name"));
    }

    @Test
    public void whenRequestToCreateItemButNoPhoneNumberAndEmailAddress_RetrieveMissingDevice_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-no-device"));
    }

    @Test
    public void whenRequestToCreateItemButPhoneIsInvalid_RetrieveInvalidPhoneNumber_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-invalid-phone"));
    }

    @Test
    public void whenRequestToCreateItemButPhoneAlreadyExists_RetrievePhoneAlreadyExists_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-exists-phone"));
    }

    @Test
    public void whenRequestToCreateItemButEmailIsInvalid_RetrieveInvalidEmailAddress_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-invalid-mail"));
    }

    @Test
    public void whenRequestToCreateItemButEmailAlreadyExists_RetrieveEmailAddressAlreadyExists_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-exists-mail"));
    }

    @Test
    public void whenRequestToCreateItemButItemNameIsNotEmailOrCpf_RetrieveWrongItemName_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-invalid-itemname"));
    }

    @Test
    public void whenCorrectRequestToCreateItemButItemExists_RetrieveItemConflict_409() throws Exception {
        conflictByHttpPost(
                props.getProperty("test.post-create-item-uri"),
                "",
                props.getProperty("test.post-create-item-conflict"));
    }

    @Test
    public void whenRequestToCreateItemButServerError_RetrieveServerError_500() throws Exception {
        boolean skip = true;
        if (!skip) {
            serverErrorByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-server-error"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItem_RetrieveItemCreated_201() throws Exception {
        boolean skip = true;
        if (!skip) {
            createdByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-correctly"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItemUsingWebHook_RetrieveItemCreated_202() throws Exception {
        boolean skip = true;
        if (!skip) {
            acceptedByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-correctly-webhook"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItemUsingJustMail_RetrieveItemCreated_201() throws Exception {
        boolean skip = true;
        if (!skip) {
            createdByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-just-using-mail"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItemUsingJustMailUsingWebHook_RetrieveItemCreated_202() throws Exception {
        boolean skip = true;
        if (!skip) {
            createdByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-just-using-mail-webhook"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItemUsingJustSms_RetrieveItemCreated_201() throws Exception {
        boolean skip = true;
        if (!skip) {
            createdByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-just-using-sms"));
        }
    }

    @Test
    public void whenCorrectRequestToCreateItemUsingJustSmsUsingWebHook_RetrieveItemCreated_202() throws Exception {
        boolean skip = true;
        if (!skip) {
            acceptedByHttpPost(
                    props.getProperty("test.post-create-item-uri"),
                    "",
                    props.getProperty("test.post-create-item-just-using-sms-webhook"));
        }
    }
}
