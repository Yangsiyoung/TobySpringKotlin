package com.ysjleader.tobyspringkotlin.chapter03.config

import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration

class ModelMapperFactory {

    companion object {
        private val INSTANCE: ModelMapper = ModelMapper().apply {
            this.configuration.isFieldMatchingEnabled = true
            this.configuration.fieldAccessLevel = Configuration.AccessLevel.PRIVATE
        }

        fun getInstance(): ModelMapper {
            return INSTANCE
        }
    }

}