import com.wg.commons.util.StringUtil;
import com.wg.domain.ShoppingInf;
import com.wg.service.ProductCalService;
import com.wg.service.ProductCalServiceImp;
import com.wg.service.ValidateAndParseService;
import com.wg.service.ValidateAndParseServiceImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    //数据校验和解析服务
    private static ValidateAndParseService validateAndParseService=new ValidateAndParseServiceImp();
    //商品计算服务
    private static ProductCalService productCalService=new ProductCalServiceImp();

    public static void main(String[] args)   {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        ShoppingInf shoppingInf=new ShoppingInf();
        System.out.println("请输入，结束请输入end：");
        try {
            while (!"end".equals(input= reader.readLine())) {
                if(StringUtil.isNotEmpty(input)){
                    validateAndParseService.validateAndParse(input,shoppingInf);
                    if(!shoppingInf.getValidateResult().isRight())
                        System.out.println(input+":"+shoppingInf.getValidateResult().getMessage());
                }
            }
            if(shoppingInf.getValidateResult().isRight()){
                if(!(shoppingInf.getSettlementInf()!=null && StringUtil.isNotEmpty(shoppingInf.getSettlementInf().getDate()))
                        && (shoppingInf.getCouponInf()!=null || shoppingInf.getProductInfList().size()>0))
                    System.out.println("没有结算日期，请重新操作！");
                else {
                    System.out.println("总额：");
                    System.out.println(StringUtil.doubleFormat2String(productCalService.cal(shoppingInf)));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
