package com.baomidou.mybatisplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
/**
 * 
 * <p>Description: </p>  
 * @author gy  
 * @date 2018年8月27日 下午2:38:34  
 * @version 1.0
 */
public class SysCodeGenerator {
	 /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
    // 选择 freemarker 引擎，默认 Veloctiy
    // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
        // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
      
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("agriculture");
        dsc.setPassword("agriculture");
        dsc.setUrl("jdbc:mysql://192.168.0.104:3306/cloud_sys_dev?characterEncoding=utf8");
        mpg.setDataSource(dsc);
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
//       G:\git\agriculture_ecp\agriculture_n\agriculture\services\agriculture-producer-service\agriculture-producer-service-provider
        gc.setOutputDir("F:\\asiainfo\\git\\cloud\\cloud\\cloud-sys-service\\cloud-sys-service-provider");  //provider工程路径
        gc.setModelOutDir("F:\\asiainfo\\git\\cloud\\cloud\\cloud-sys-service\\cloud-sys-service-model");  //entity工程路径
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
 
        //代码生成作者
        gc.setAuthor("liuwy");
        gc.setOpen(false);
        
        /**
         * 文件是否覆盖。。默认是，配合文件生成控制
         */
        gc.setFileOverride(true);
        
        mpg.setGlobalConfig(gc);
        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setParent("com.ai");
        pc.setModuleName("sys");

        mpg.setPackageInfo(pc);

        // 生成策略配置 sys_user 
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "t_sys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { "t_sys_menu_api" }); // 需要生成的表
        mpg.setStrategy(strategy);
        
        /**
         * 生成文件控制
         */
        TemplateConfig tc = new TemplateConfig();
        //tc.setController(null); //默认不生成
        //tc.setEntity(null);  //默认生成
       //tc.setMapper(null);  //默认生成
       // tc.setXml(null);  //默认生成/         
        //tc.setService(null);  //默认不生成
       // tc.setServiceImpl(null);  //默认不生成
        //tc.setModel(null); //默认生成
        //tc.setApi(null);  //默认不生成
         mpg.setTemplate(tc);
         
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(true);
       
/**
 * 分割线下配置请忽略，开发用不到
 * ----------------------------------------------------------------------------------------------------------
 */
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        /*focList.add(new FileOutConfig("/template/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "D://my_" + tableInfo.getEntityName() + ".jsp";
            }
        });*/
        // cfg.setFileOutConfigList(focList);
        //mpg.setCfg(cfg);

        // 调整 xml 生成目录演示
       /* focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/mybatis/"+pc.getModuleName()+ "/" + tableInfo.getEntityName() + ".xml";
            }
        });*/
        // 调整 model 生成目录演示
        /*focList.add(new FileOutConfig("/templates/model.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/mybatis/"+pc.getModuleName()+ "/" + tableInfo.+ ".java";
            }
        });*/
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        //TemplateConfig tc = new TemplateConfig();
        //tc.setXml(null);
        //mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        

        // 执行生成 
        mpg.execute();

        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
}
