package com.example.retrofitcrud.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error {

        @SerializedName("return")
        @Expose
        private Boolean _return;
        @SerializedName("errors")
        @Expose
        private Errors errors;

        public Boolean getReturn() {
            return _return;
        }

        public void setReturn(Boolean _return) {
            this._return = _return;
        }

        public Errors getErrors() {
            return errors;
        }

        public void setErrors(Errors errors) {
            this.errors = errors;
        }

    @Override
    public String toString() {
        return "Error{" +
                "_return=" + _return +
                ", errors=" + errors +
                '}';
    }

    public static class Errors {

        @SerializedName("message")
        @Expose
        private String message;

        @SerializedName("mobile")
        @Expose
        private String mobile;

        @SerializedName("password")
        @Expose
        private String password;

        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("username")
        @Expose
        private String username;

        @SerializedName("name")
        @Expose
        private String name;

        @Override
        public String toString() {
            return "Errors{" +
                    "message='" + message + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
