import org.apache.commons.lang3.StringUtils

fun mask(input: String?, size: Int): String? {
    return StringUtils.leftPad(StringUtils.right(input, size), StringUtils.length(input), '*')
}

fun rightMask(input: String?, size: Int): String? {
    return StringUtils.rightPad(StringUtils.left(input, size), StringUtils.length(input), '*')
}
