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

//改变列颜色自定义renderner方法
function renderMotif(data, cell, record, rowIndex, columnIndex, store){
    var value = record.get('name');
    cell.style="background-color:"+value;
    return data;
}