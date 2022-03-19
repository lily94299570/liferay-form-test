package com.liferay.base;

public class Messages {
        public String getCondition() {
            return _conditionText;
        }

        public void setCondition(String text) {
            _conditionText = text;
        }

        public String getPTValue() {
            return _ptValueText;
        }

        public void setPTValue(String text) {
            _ptValueText = text;
        }

        public String getValue() {
            return _valueText;
        }

        public void setValue(String text) {
            _valueText = text;
        }

        private String _conditionText;
        private String _ptValueText;
        private String _valueText;
}
