package org.example.ex10.model;

public enum ModelType {
    GROQ_LLAMA("llama-3.3-70b-versatile", ModelPlatform.GROQ),
    TOGETHER_LLAMA("meta-llama/Llama-3.3-70B-Instruct-Turbo", ModelPlatform.TOGETHER)
    ;

    public final String name;
    public final ModelPlatform platform;

    ModelType(String name, ModelPlatform platform) {
        this.name = name;
        this.platform = platform;
    }
}
