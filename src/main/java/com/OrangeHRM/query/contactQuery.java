package com.icrm.query;

public class contactQuery {

    public static String getContactInfoQuery(String name){
        return "SELECT CASE c.salutation " +
                " WHEN 0 THEN 'None' " +
                " WHEN 1 THEN 'Mr.' " +
                " WHEN 2 THEN 'Mrs.' " +
                " WHEN 3 THEN 'Ms.' " +
                " WHEN 4 THEN 'Dr.' " +
                " WHEN 5 THEN 'Prof.'" +
                " END AS salutation, " +
                " CASE c.lead_src " +
                " WHEN 0 THEN 'Existing Customer' " +
                " WHEN 1 THEN 'Partner' " +
                " WHEN 2 THEN 'Conference' " +
                " WHEN 3 THEN 'Website' " +
                " WHEN 4 THEN 'Word of mouth' " +
                " WHEN 5 THEN 'Other'" +
                " END AS lead_src, " +
                " u.name AS assigned_to " +
                " FROM contact c " +
                " LEFT JOIN user u ON c.assigned_to = u.pk " +
                " WHERE c.contact_name = '" + name +"'";
    }

    public static String getContactDetailQuery(String name){
        return "SELECT " +
            "c.contact_name, " +

            "CASE c.salutation " +
            "WHEN 0 THEN 'None' " +
            "WHEN 1 THEN 'Mr.' " +
            "WHEN 2 THEN 'Mrs.' " +
            "WHEN 3 THEN 'Ms.' " +
            "WHEN 4 THEN 'Dr.' " +
            "WHEN 5 THEN 'Prof.' " +
            "END AS salutation, " +

            "c.email, " +
            "c.mobile_phone, " +
            "c.organization, " +

            "CASE c.lead_src " +
            "WHEN 0 THEN 'Existing Customer' " +
            "WHEN 1 THEN 'Partner' " +
            "WHEN 2 THEN 'Conference' " +
            "WHEN 3 THEN 'Website' " +
            "WHEN 4 THEN 'Word of mouth' " +
            "WHEN 5 THEN 'Other' " +
            "END AS lead_src, " +

            "u1.name AS assigned_to, " +
            "u2.name AS creator, " +

            "c.dob, " +

            "c.address, " +
            "c.description, " +

            "c.created_on, " +
            "c.updated_on " +

            "FROM contact c " +
            "LEFT JOIN user u1 ON c.assigned_to = u1.pk " +
            "LEFT JOIN user u2 ON c.creator = u2.pk " +

            "WHERE c.contact_name = '" + name + "'";
    }

        public static String getContactDetailEditQuery(String name){
        return "SELECT " +
            "c.contact_name, " +

            "CASE c.salutation " +
            "WHEN 0 THEN 'None' " +
            "WHEN 1 THEN 'Mr.' " +
            "WHEN 2 THEN 'Mrs.' " +
            "WHEN 3 THEN 'Ms.' " +
            "WHEN 4 THEN 'Dr.' " +
            "WHEN 5 THEN 'Prof.' " +
            "END AS salutation, " +

            "c.email, " +
            "c.mobile_phone, " +
            "c.organization, " +

            "CASE c.lead_src " +
            "WHEN 0 THEN 'Existing Customer' " +
            "WHEN 1 THEN 'Partner' " +
            "WHEN 2 THEN 'Conference' " +
            "WHEN 3 THEN 'Website' " +
            "WHEN 4 THEN 'Word of mouth' " +
            "WHEN 5 THEN 'Other' " +
            "END AS lead_src, " +

            "u1.name AS assigned_to, " +

            "c.dob, " +

            "c.address, " +
            "c.description " +

            "FROM contact c " +
            "LEFT JOIN user u1 ON c.assigned_to = u1.pk "+ 

            "WHERE c.contact_name = '" + name + "'";
    }
    

    public static String checkTheRecordIsExist(String name){
        return "SELECT * FROM Contacts WHERE name = '" + name + "'";
    }
}
