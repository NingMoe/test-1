/**
 * Created by luopan on 12/2/2016.
 */
/**
 */
function formatGenger(value) {
    console.log(this.config.paths)
    if(value == 1){
        return "<img src='/ext4/resources/icons/user.png' />";
    }else if(value == 0){
        return "<img src='/ext4/resources/icons/user_female.png' />";
    }else{
        return value;
    }
}