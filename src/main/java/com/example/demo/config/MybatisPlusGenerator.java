package com.example.demo.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @ClassName MybatisPlusGententor
 * @Description mp代码生成器
 * @Author WangZhe
 * @Date 2022/5/12 9:01
 * @Version 1.0
 */


public class MybatisPlusGenerator {
    private static String url = "jdbc:mysql://localhost:3306/security";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) {
        String baseDir = System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
        String classDir = baseDir + "/src/main/java";
        String xmlDir = baseDir + "/src/main/resources/mapper";


        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("wangzhe") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(classDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.demo") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImp")
                            .build();; // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
